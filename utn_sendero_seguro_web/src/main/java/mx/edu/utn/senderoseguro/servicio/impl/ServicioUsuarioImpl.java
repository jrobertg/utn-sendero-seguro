package mx.edu.utn.senderoseguro.servicio.impl;

import static mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase.obtenerRespuestaBaseErronea;
import static mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase.obtenerRespuestaBaseExitosa;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.edu.utn.senderoseguro.mapper.UserMapper;
import mx.edu.utn.senderoseguro.modelo.Role;
import mx.edu.utn.senderoseguro.modelo.User;
import mx.edu.utn.senderoseguro.repositorio.RepositorioUsuario;
import mx.edu.utn.senderoseguro.servicio.ServicioUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.RegistroUsuarioDTO;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuario;
import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicioUsuarioImpl implements ServicioUsuario {

	private final UserMapper userMapper;
	private final RepositorioUsuario userRepository;

	@Override
	public User save(RegistroUsuarioDTO registrationDto) {
		User user = new User()
				.setIdStatus(2)
				.setFirstName(registrationDto.getFirstName())
				.setLastName(registrationDto.getLastName())
				.setEmail(registrationDto.getEmail())
				.setPassword(new BCryptPasswordEncoder().encode(registrationDto.getPassword()))
				.setRoles(Arrays.asList(new Role("USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailAndIdStatus(username, 1);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new mx.edu.utn.senderoseguro.web.controlador.dto.Usuario(user);
	}

	@Override
	public User obtenerUsuarioPorCorreo(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ModeloUsuario> obtenerConsultaModeloUsuarios(BaseFilter filtros) {
		return userMapper.obtenerConsultaModeloUsuarios(filtros);
	}

	@Override
	@Transactional
	public RespuestaBase activarUsuarios(SolicitudActivarUsuario solicitudActivarUsuario) {
		try {
			int registrosActualizados = userMapper.activarUsuarios(solicitudActivarUsuario.getIdUsuarios());
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
	public RespuestaBase inactivarUsuarios(SolicitudInactivarUsuario solicitudInactivarUsuario) {
		try {
			int registrosActualizados = userMapper.inactivarUsuarios(solicitudInactivarUsuario.getIdUsuarios());
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

}
