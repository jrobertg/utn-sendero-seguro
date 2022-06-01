package mx.edu.utn.senderoseguro.web.datatables;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * The Class DataTableResults.
 *
 * @author pavan.solapure
 * @param <T> the generic type
 */
@Data
@Accessors(chain = true)
public class DataTableResults<T> {

	/** The draw. */
	private Integer draw;

	/** The records filtered. */
	private Integer recordsFiltered;

	/** The records total. */
	private Integer recordsTotal;

	/** The list of data objects. */
	private List<T> data;

}