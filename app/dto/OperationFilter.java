package dto;

/**
 * Request object for retrieve operations by date and type
 * @author ra - created 13.02.2016.
 * @since 0.1.0
 */
public class OperationFilter {
    private String dateFrom;
    private String dateTo;
    private String type;
    private Short limit=100;
    private Long offset=0L;

    /**
     * Operations will be retrieved starting from this date
     * @return
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * Operations will be retrieved starting from this date, must be in 'yyyy-MM-dd' format
     * @param dateFrom
     */
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * Operations will be retrieved before this date
     * @return
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * Operations will be retrieved before this date, must be in 'yyyy-MM-dd' format
     * @param dateTo
     */
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * Operations for this type will be retrieved.
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Operations for this type will be retrieved. If not specified operations of all types will be retrieved.
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Operations limit. 100 by default
     * @return
     */
    public Short getLimit() {
        return limit;
    }

    /**
     * perations limit. 100 by default
     * @param limit
     */
    public void setLimit(Short limit) {
        this.limit = limit;
    }

    /**
     * Operations offset. 0 by default
     * @return
     */
    public Long getOffset() {
        return offset;
    }

    /**
     * Operations offset. 0 by default
     * @param offset
     */
    public void setOffset(Long offset) {
        this.offset = offset;
    }
}
