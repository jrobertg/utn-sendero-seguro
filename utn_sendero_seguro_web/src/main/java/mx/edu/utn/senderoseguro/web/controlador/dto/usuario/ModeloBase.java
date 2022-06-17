package mx.edu.utn.senderoseguro.web.controlador.dto.usuario;

import java.io.Serializable;

import lombok.Data;

@Data
public class ModeloBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int totalRecords;

	private int rnum;

}
