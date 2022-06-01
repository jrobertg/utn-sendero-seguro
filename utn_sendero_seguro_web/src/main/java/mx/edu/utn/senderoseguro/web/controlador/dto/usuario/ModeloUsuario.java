package mx.edu.utn.senderoseguro.web.controlador.dto.usuario;

import java.io.Serializable;

import lombok.Data;

@Data
public class ModeloUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private Integer idStatus;
	
	private int totalRecords;

	private int rnum;

}
