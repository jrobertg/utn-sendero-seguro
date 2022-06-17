package mx.edu.utn.senderoseguro.web.controlador.dto.usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ModeloUsuarioMovil extends ModeloBase {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idUsuarioMovil;

	private String correo;

	private String nombres;

	private String apellidos;

	private Integer idTipoUsuario;

	private String tipoUsuario;

	private Integer idEstatus;

	private String estatusUsuario;

}
