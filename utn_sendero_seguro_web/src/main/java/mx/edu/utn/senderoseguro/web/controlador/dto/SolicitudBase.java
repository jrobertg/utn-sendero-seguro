package mx.edu.utn.senderoseguro.web.controlador.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SolicitudBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idUsuarioSolicitante;

}
