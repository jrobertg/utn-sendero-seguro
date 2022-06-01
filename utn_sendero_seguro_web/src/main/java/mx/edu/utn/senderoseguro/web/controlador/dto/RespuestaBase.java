package mx.edu.utn.senderoseguro.web.controlador.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RespuestaBase {
	
	private Integer codigo;
	
	private String mensaje;
	
	public static RespuestaBase obtenerRespuestaBaseErronea(String mensaje) {
		return new RespuestaBase()
				.setCodigo(-1)
				.setMensaje(mensaje);
	}
	
	public static RespuestaBase obtenerRespuestaBaseExitosa(String mensaje) {
		return new RespuestaBase()
				.setCodigo(0)
				.setMensaje(mensaje);
	}

}
