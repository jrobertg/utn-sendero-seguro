package mx.edu.utn.senderoseguro.servicio.impl;

import static java.time.LocalDateTime.now;
import static java.util.Objects.nonNull;
import static mx.edu.utn.senderoseguro.entidad.CatalogoEstatusUsuario.ACTIVO;
import static mx.edu.utn.senderoseguro.entidad.CatalogoEstatusUsuario.INACTIVO;
import static mx.edu.utn.senderoseguro.entidad.CatalogoTipoUsuario.CONDUCTOR;
import static mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase.obtenerRespuestaBaseErronea;
import static mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase.obtenerRespuestaBaseExitosa;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.edu.utn.senderoseguro.entidad.CatalogoRolWeb;
import mx.edu.utn.senderoseguro.entidad.UsuarioMovil;
import mx.edu.utn.senderoseguro.entidad.UsuarioWeb;
import mx.edu.utn.senderoseguro.mapper.CatalogoRolWebMapper;
import mx.edu.utn.senderoseguro.mapper.UsuarioMovilMapper;
import mx.edu.utn.senderoseguro.mapper.UsuarioWebMapper;
import mx.edu.utn.senderoseguro.servicio.ServicioUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase;
import mx.edu.utn.senderoseguro.web.controlador.dto.Usuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioMovil;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.RegistroUsuarioDTO;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuariosMovil;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuariosMovil;
import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicioUsuarioImpl implements ServicioUsuario {

	private final UsuarioWebMapper usuarioWebMapper;
	private final UsuarioMovilMapper usuarioMovilMapper;
	private final CatalogoRolWebMapper catalogoRolWebMapper;

	@Override
	@Transactional
	public RespuestaBase registraUsuarioWeb(RegistroUsuarioDTO registroUsuarioDTO) {
		try {
			Optional<UsuarioWeb> optional = usuarioWebMapper.obtenerPorCorreo(registroUsuarioDTO.getCorreo());
			if (optional.isEmpty()) {
				int registrosAlmacenados = usuarioWebMapper.insertSelective(new UsuarioWeb()
						.setCorreo(registroUsuarioDTO.getCorreo())
						.setContrasena(new BCryptPasswordEncoder().encode(registroUsuarioDTO.getContrasena()))
						.setNombres(registroUsuarioDTO.getNombres())
						.setApellidos(registroUsuarioDTO.getApellidos())
						.setIdRolWeb(registroUsuarioDTO.getIdRolWeb())
						.setIdEstatus(INACTIVO)
						.setFechaCreacionBd(now())
						.setFechaUltimoMovimiento(now()));
				return obtenerRespuestaBaseExitosa(registrosAlmacenados + " registro(s) alamcenado(s).");
			} else {
				return obtenerRespuestaBaseErronea("El correo " + registroUsuarioDTO.getCorreo() + " ya existe.");
			}
		} catch (Exception e) {
			log.error("Error al registrar el usuario." + e.getMessage(), e);
			return obtenerRespuestaBaseErronea("Error al registrar el usuario.");
		}
	}
	
	@Override
	@Transactional
	public RespuestaBase registraUsuarioConductor(RegistroUsuarioDTO registroUsuarioDTO) {
		try {
			Optional<UsuarioMovil> optional = usuarioMovilMapper.obtenerPorCorreo(registroUsuarioDTO.getCorreo());
			if (optional.isEmpty()) {
				int registrosAlmacenados = usuarioMovilMapper.insertSelective(new UsuarioMovil()
						.setCorreo(registroUsuarioDTO.getCorreo())
						.setContrasena(new BCryptPasswordEncoder().encode(UUID.randomUUID().toString()))
						.setNombres(registroUsuarioDTO.getNombres())
						.setApellidos(registroUsuarioDTO.getApellidos())
						.setIdTipoUsuario(CONDUCTOR)
						.setIdEstatus(INACTIVO)
						.setFechaCreacionBd(now())
						.setFechaUltimoMovimiento(now()));
				return obtenerRespuestaBaseExitosa(registrosAlmacenados + " registro(s) alamcenado(s).");
			} else {
				return obtenerRespuestaBaseErronea("El correo " + registroUsuarioDTO.getCorreo() + " ya existe.");
			}
		} catch (Exception e) {
			log.error("Error al registrar el usuario." + e.getMessage(), e);
			return obtenerRespuestaBaseErronea("Error al registrar el usuario.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Optional<UsuarioWeb> optional = usuarioWebMapper.obtenerPorCorreoYEstatus(correo, ACTIVO);
		if (optional.isEmpty()) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		UsuarioWeb usuarioWeb = optional.get();
		return new Usuario(usuarioWeb, Arrays.asList(catalogoRolWebMapper.selectByPrimaryKey(usuarioWeb.getIdRolWeb()).get()));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ModeloUsuarioWeb> obtenerModeloUsuariosWeb(BaseFilter filtros) {
		return usuarioWebMapper.obtenerModeloUsuariosWeb(filtros);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ModeloUsuarioMovil> obtenerModeloUsuariosMovil(BaseFilter filtros) {
		return usuarioMovilMapper.obtenerModeloUsuariosMovil(filtros);
	}

	@Override
	@Transactional
	public RespuestaBase activarUsuarioWeb(SolicitudActivarUsuarioWeb solicitudActivarUsuario) {
		try {
			int registrosActualizados = usuarioWebMapper.updateByPrimaryKeySelective(
					new UsuarioWeb().setIdUsuarioWeb(solicitudActivarUsuario.getIdUsuarioWeb()).setIdEstatus(ACTIVO));
			if (registrosActualizados == 0) {
				return obtenerRespuestaBaseExitosa("Ningún registro activado.");
			} else if (registrosActualizados == 1) {
				return obtenerRespuestaBaseExitosa("Registro activado correctamente.");
			} else {
				return obtenerRespuestaBaseExitosa("Los " + registrosActualizados + " registros fueron activados correctamente.");
			}
		} catch (Exception e) {
			log.error("Error al activar usuarios.", e);
			return obtenerRespuestaBaseErronea("Error al activar usuarios, favor de contactar al administrador");
		}
	}
	
	@Override
	@Transactional
	public RespuestaBase inactivarUsuarioWeb(SolicitudInactivarUsuarioWeb solicitudInactivarUsuario) {
		try {
			if (solicitudInactivarUsuario.getIdUsuarioWeb().intValue() == 1) {
				solicitudInactivarUsuario.setIdUsuarioWeb(0);
			}
			int registrosActualizados = usuarioWebMapper.updateByPrimaryKeySelective(
					new UsuarioWeb().setIdUsuarioWeb(solicitudInactivarUsuario.getIdUsuarioWeb()).setIdEstatus(INACTIVO));
			if (registrosActualizados == 0) {
				return obtenerRespuestaBaseExitosa("Ningún registro inactivado.");
			} else if (registrosActualizados == 1) {
				return obtenerRespuestaBaseExitosa("Registro inactivado correctamente.");
			} else {
				return obtenerRespuestaBaseExitosa("Los " + registrosActualizados + " registros fueron inactivados correctamente.");
			}
		} catch (Exception e) {
			log.error("Error al inactivar usuarios.", e);
			return obtenerRespuestaBaseErronea("Error al inactivar usuarios, favor de contactar al administrador");
		}
	}

	@Override
	public RespuestaBase activarUsuariosMovil(SolicitudActivarUsuariosMovil solicitudActivarUsuariosMovil) {
		int registrosActualizados = 0;
		int registrosFallidos = 0;
		if (nonNull(solicitudActivarUsuariosMovil) && nonNull(solicitudActivarUsuariosMovil.getIdUsuarios())) {
			for (Integer idUsuario : solicitudActivarUsuariosMovil.getIdUsuarios()) {
				try {
					registrosActualizados += activarUsuarioMovil(idUsuario);
				} catch(Exception e) {
					log.error("Error al activar al usuario " + idUsuario, e);
					registrosFallidos++;
				}
			}
		}
		RespuestaBase respuesta = obtenerRespuestaBaseExitosa("");
		if (registrosFallidos > 0) {
			respuesta.setMensaje("En la solicitud hubo " + registrosFallidos + " registro(s) fallido(s) y "
				+ registrosActualizados + " registro(s) exitoso(s).");
		} else {
			respuesta.setMensaje("En la solicitud hubo " + registrosActualizados + " registro(s) exitoso(s).");
		}
		return respuesta;
	}
	
	@Transactional
	private int activarUsuarioMovil(Integer idUsuarioMovil) throws SQLException {
		return usuarioMovilMapper.updateByPrimaryKeySelective(
				new UsuarioMovil().setIdUsuarioMovil(idUsuarioMovil)
				.setIdEstatus(ACTIVO).setFechaUltimoMovimiento(now()));
	}

	@Override
	public RespuestaBase inactivarUsuariosMovil(SolicitudInactivarUsuariosMovil solicitudInactivarUsuariosMovil) {
		int registrosActualizados = 0;
		int registrosFallidos = 0;
		if (nonNull(solicitudInactivarUsuariosMovil) && nonNull(solicitudInactivarUsuariosMovil.getIdUsuarios())) {
			for (Integer idUsuario : solicitudInactivarUsuariosMovil.getIdUsuarios()) {
				try {
					registrosActualizados += inactivarUsuarioMovil(idUsuario);
				} catch(Exception e) {
					log.error("Error al inactivar al usuario " + idUsuario, e);
					registrosFallidos++;
				}
			}
		}
		RespuestaBase respuesta = obtenerRespuestaBaseExitosa("");
		if (registrosFallidos > 0) {
			respuesta.setMensaje("En la solicitud hubo " + registrosFallidos + " registro(s) fallido(s) y "
				+ registrosActualizados + " registro(s) exitoso(s).");
		} else {
			respuesta.setMensaje("En la solicitud hubo " + registrosActualizados + " registro(s) exitoso(s).");
		}
		return respuesta;
	}
	
	@Transactional
	private int inactivarUsuarioMovil(Integer idUsuarioMovil) throws SQLException {
		return usuarioMovilMapper.updateByPrimaryKeySelective(
				new UsuarioMovil().setIdUsuarioMovil(idUsuarioMovil)
				.setIdEstatus(INACTIVO).setFechaUltimoMovimiento(now()));
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatalogoRolWeb> obtenerRolesWeb() {
		return catalogoRolWebMapper.obtenerRolesWeb();
	}

}
