package mx.edu.utn.senderoseguro.web.datatables;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDatatablesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer rnum;
	
	private Integer totalRecords;

}
