package mx.edu.utn.senderoseguro.web.controlador.dto.usuario;

import lombok.Data;

@Data
public class RegistroUsuarioDTO {
	
	private String nombres;
	private String apellidos;
	private String correo;
	private String contrasena;
	private Integer idRolWeb;
	
}
