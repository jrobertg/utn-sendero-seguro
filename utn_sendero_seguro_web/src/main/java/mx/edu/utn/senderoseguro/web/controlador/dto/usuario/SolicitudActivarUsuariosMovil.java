package mx.edu.utn.senderoseguro.web.controlador.dto.usuario;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.edu.utn.senderoseguro.web.controlador.dto.SolicitudBase;

@Data
@EqualsAndHashCode(callSuper = false)
public class SolicitudActivarUsuariosMovil extends SolicitudBase {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> idUsuarios;

}
