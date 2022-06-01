/**
 * 
 */
package mx.edu.utn.senderoseguro.web.datatables;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gabr@praxis.com.mx
 *
 */
@Slf4j
public class PaginationCriteria {

	protected PaginationCriteria() {
	}

	/** The Constant BLANK. */
	private static final String BLANK = "";

	/** The Constant SPACE. */
	private static final String SPACE = " ";

	/** The Constant LIKE_PREFIX. */
	private static final String LIKE_PREFIX = " LIKE '%";

	/** The Constant LIKE_SUFFIX. */
	private static final String LIKE_SUFFIX = "%' ";

	/** The Constant AND. */
	private static final String AND = " AND ";

	/** The Constant OR. */
	private static final String OR = " OR ";

	/** The Constant ORDER_BY. */
	private static final String ORDER_BY = " ORDER BY ";

	private static final String BRKT_OPN = " ( ";

	private static final String BRKT_CLS = " ) ";

	/** The Constant COMMA. */
	private static final String COMMA = " , ";

	/** The Constant PAGE_NO. */
	public static final String PAGE_NO = "start";

	/** The Constant PAGE_SIZE. */
	public static final String PAGE_SIZE = "length";

	/** The Constant DRAW. */
	public static final String DRAW = "draw";

	/** The page number. */
	private Integer pageNumber;

	/** The page size. */
	private Integer pageSize;

	/** The total records. */
	private Integer totalRecords;

	/** The sort by. */
	private SortBy sortBy;

	/** The filter by. */
	private FilterBy filterBy;

	/**
	 * Gets the page number.
	 *
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return (null == pageNumber) ? 0 : pageNumber;
	}

	/**
	 * Sets the page number.
	 *
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return (null == pageSize) ? 10 : pageSize;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Gets the total records.
	 *
	 * @return the totalRecords
	 */
	public Integer getTotalRecords() {
		return totalRecords;
	}

	/**
	 * Sets the total records.
	 *
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * Gets the sort by.
	 *
	 * @return the sortBy
	 */
	public SortBy getSortBy() {
		return sortBy;
	}

	/**
	 * Sets the sort by.
	 *
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(SortBy sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * Gets the filter by.
	 *
	 * @return the filterBy
	 */
	public FilterBy getFilterBy() {
		return filterBy;
	}

	/**
	 * Sets the filter by.
	 *
	 * @param filterBy the filterBy to set
	 */
	public void setFilterBy(FilterBy filterBy) {
		this.filterBy = filterBy;
	}

	/**
	 * Checks if is filter by empty.
	 *
	 * @return true, if is filter by empty
	 */
	public boolean isFilterByEmpty() {
		if (null == filterBy || null == filterBy.getMapOfFilters() || filterBy.getMapOfFilters().size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if is sort by empty.
	 *
	 * @return true, if is sort by empty
	 */
	public boolean isSortByEmpty() {
		if (null == sortBy || null == sortBy.getSortBys() || sortBy.getSortBys().size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the filter by clause.
	 *
	 * @return the filter by clause
	 */
	public String getFilterByClause() {		
		StringBuilder fbsb = null;
		
		if (!isFilterByEmpty()) {
			Iterator<Entry<String, String>> fbit = filterBy.getMapOfFilters().entrySet().iterator();			
			while (fbit.hasNext()) {
				
				Map.Entry<String, String> pair =  fbit.next();
				
				if(null == fbsb) {
					fbsb = new StringBuilder();
					fbsb.append(BRKT_OPN);
					
					fbsb.append(SPACE)
							.append(BRKT_OPN)
								.append(pair.getKey())
									.append(LIKE_PREFIX)
										.append(pair.getValue())
											.append(LIKE_SUFFIX)
												.append(BRKT_CLS);
					
				} else {
					
					fbsb.append(filterBy.isGlobalSearch() ? OR : AND)
							.append(BRKT_OPN)
								  .append(pair.getKey())
									.append(LIKE_PREFIX)
										.append(pair.getValue())
											.append(LIKE_SUFFIX)
												.append(BRKT_CLS);
					
				}
			}
			fbsb.append(BRKT_CLS);
		}
		return (null == fbsb) ? BLANK : fbsb.toString();
	}
	
	/**
	 * Gets the order by clause.
	 *
	 * @return the order by clause
	 */
	public String getOrderByClause() {
		
		StringBuilder sbsb = null;
		
		if(!isSortByEmpty()) {
			Iterator<Entry<String, SortOrder>> sbit = sortBy.getSortBys().entrySet().iterator();
			
			while (sbit.hasNext()) {
				Map.Entry<String, SortOrder> pair =  sbit.next();
				if(null == sbsb) {
					sbsb = new StringBuilder();
					sbsb.append(ORDER_BY).append(pair.getKey()).append(SPACE).append(pair.getValue());
				} else {
					sbsb.append(COMMA).append(pair.getKey()).append(SPACE).append(pair.getValue());
				}
			}
		}
		
		return (null == sbsb) ? BLANK : sbsb.toString();
	}
	
	public static void customCriteriosFilter(DataTableRequest<BaseDatatablesDTO> dataTableInRQ) throws Exception {
		BaseFilter filter = new BaseFilter();
		dataTableInRQ.setBaseFilter(filter);
		
		filter.setOrden(dataTableInRQ.getOrder().get(0).getDir());
		filter.setOrderBy(dataTableInRQ.getOrder().get(0).getColumn());
		filter.setSearch(dataTableInRQ.getSearch().getValue());
    	filter.setStart(dataTableInRQ.getStart());
    	filter.setEnd(dataTableInRQ.getLength());
	}
	
	/**
	 * Gets the pagination request.
	 *
	 * @return the pagination request
	 */
	public static PaginationCriteria getPaginationRequest(DataTableRequest<BaseDatatablesDTO> dataTableInRQ) throws Exception {
		dataTableInRQ.setGlobalSearch( (!isObjectEmpty(dataTableInRQ.getSearch()) && !isObjectEmpty(dataTableInRQ.getSearch().getValue())) );
		for (DataTableColumnSpecs colSpec : dataTableInRQ.getColumns()) {
			if (!isObjectEmpty(colSpec.getSearch()) && !isObjectEmpty(colSpec.getSearch().getValue())) {
				dataTableInRQ.setGlobalSearch(false);
			}
		}
		
		PaginationCriteria pagination = new PaginationCriteria();
		pagination.setPageNumber(dataTableInRQ.getStart());
		pagination.setPageSize(dataTableInRQ.getLength());

		SortBy sortBy = null;
		if (!isObjectEmpty(dataTableInRQ.getOrder())) {
			try {
				sortBy = new SortBy();
				OrderBy orderBy = dataTableInRQ.getOrder().get(0);
				DataTableColumnSpecs colSpec = dataTableInRQ.getColumns().get(orderBy.getColumn());
				sortBy.addSort(colSpec.getData(), SortOrder.fromValue(orderBy.getDir()));
			} catch (IndexOutOfBoundsException e) {
				log.error("Error IndexOutOfBoundsException: ", e);
				throw new Exception("Error al definir un sortBy " + e.getMessage());
			}
		}

		FilterBy filterBy = new FilterBy();
		filterBy.setGlobalSearch(dataTableInRQ.isGlobalSearch());
		for (DataTableColumnSpecs colSpec : dataTableInRQ.getColumns()) {
			if (colSpec.isSearchable()) {
				if (
						!isObjectEmpty(dataTableInRQ.getSearch()) &&
						!isObjectEmpty(dataTableInRQ.getSearch().getValue()) ||
						(!isObjectEmpty(colSpec.getSearch()) &&
						!isObjectEmpty(colSpec.getSearch().getValue()))
				) {
					filterBy.addFilter(colSpec.getData(),
							(dataTableInRQ.isGlobalSearch()) ? dataTableInRQ.getSearch().getValue() : colSpec.getSearch().getValue());
				}
			}
		}

		pagination.setSortBy(sortBy);
		pagination.setFilterBy(filterBy);

		return pagination;
	}
	
	public static boolean isObjectEmpty(Object object) {
		if (object == null)
			return true;
		else if (object instanceof String) {
			if (((String) object).trim().length() == 0) {
				return true;
			}
		} else if (object instanceof Collection<?>) {
			return isCollectionEmpty((Collection<?>) object);
		}
		return false;
	}
	
	private static boolean isCollectionEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}

}
