package mx.edu.utn.senderoseguro.web.controlador.dto.usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ModeloUsuarioWeb extends ModeloBase {

	private static final long serialVersionUID = 1L;

	private Integer idUsuarioWeb;

	private String correo;

	private String nombres;

	private String apellidos;

	private Integer idRolWeb;

	private String rolWeb;

	private Integer idEstatus;

	private String estatusUsuario;

}
