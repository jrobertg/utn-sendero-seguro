package mx.edu.utn.senderoseguro.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import mx.edu.utn.senderoseguro.entidad.CatalogoRolWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioMovil;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.RegistroUsuarioDTO;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuariosMovil;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuariosMovil;
import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

public interface ServicioUsuario extends UserDetailsService {

	RespuestaBase registraUsuarioWeb(RegistroUsuarioDTO registroUsuarioDTO);
	
	RespuestaBase registraUsuarioConductor(RegistroUsuarioDTO registroUsuarioDTO);
	
	List<ModeloUsuarioWeb> obtenerModeloUsuariosWeb(BaseFilter filtros);
	
	List<ModeloUsuarioMovil> obtenerModeloUsuariosMovil(BaseFilter filtros);
	
	RespuestaBase activarUsuariosMovil(SolicitudActivarUsuariosMovil solicitudActivarUsuariosMovil);
	
	RespuestaBase activarUsuarioWeb(SolicitudActivarUsuarioWeb solicitudActivarUsuario);
	
	RespuestaBase inactivarUsuariosMovil(SolicitudInactivarUsuariosMovil solicitudInactivarUsuariosMovil);
	
	RespuestaBase inactivarUsuarioWeb(SolicitudInactivarUsuarioWeb solicitudInactivarUsuario);
	
	List<CatalogoRolWeb> obtenerRolesWeb();

}
