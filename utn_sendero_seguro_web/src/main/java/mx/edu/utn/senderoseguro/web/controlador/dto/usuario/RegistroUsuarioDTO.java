package mx.edu.utn.senderoseguro.web.controlador.dto.usuario;

import lombok.Data;

@Data
public class RegistroUsuarioDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}
