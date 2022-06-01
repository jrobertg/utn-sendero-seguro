package mx.edu.utn.senderoseguro.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import mx.edu.utn.senderoseguro.modelo.User;
import mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.RegistroUsuarioDTO;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuario;
import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

public interface ServicioUsuario extends UserDetailsService {

	User save(RegistroUsuarioDTO registrationDto);
	
	User obtenerUsuarioPorCorreo(String email);
	
	List<ModeloUsuario> obtenerConsultaModeloUsuarios(BaseFilter filtros);
	
	RespuestaBase activarUsuarios(SolicitudActivarUsuario solicitudActivarUsuario);
	
	RespuestaBase inactivarUsuarios(SolicitudInactivarUsuario solicitudInactivarUsuario);

}
