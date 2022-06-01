package mx.edu.utn.senderoseguro.web.datatables;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class DataTableRequest.
 *
 * @author pavan.solapure
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataTableRequest<T> {

	/** The unique id. */
	private String uniqueId;

	/** The draw. */
	private Integer draw;

	/** The start. */
	private Integer start;

	/** The length. */
	private Integer length;

	/** The search. */
	private Search search;

	/** The columns. */
	private List<DataTableColumnSpecs> columns;

	/** The order. */
	private List<OrderBy> order;

	/** The is global search. */
	private boolean globalSearch;

	/** The max params to check. */
	private Integer maxParamsToCheck = 0;
	
	private BaseFilter baseFilter;

}