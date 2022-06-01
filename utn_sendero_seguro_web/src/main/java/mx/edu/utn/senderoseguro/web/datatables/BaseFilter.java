package mx.edu.utn.senderoseguro.web.datatables;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseFilter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer start;
	private Integer end;
	private String orden;
	private Integer orderBy;
	private String search;

}
