package dto.customer;

/**
 * Api customer transactions request object
 * @author ra created 17.02.2016.
 * @since 0.2.0
 */
public class CustomerTransactionFilter {
    private Long cardId;
    private String fromDate;
    private String toDate;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    /**
     * Transactions will be retrieved from this date. Must be in yyyy-MM-dd format
     * @return
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Transactions will be retrieved from this date. Must be in yyyy-MM-dd format
     * @param fromDate
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Transactions will be retrieved before this date. Must be in yyyy-MM-dd format
     * @return
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Transactions will be retrieved before this date. Must be in yyyy-MM-dd format
     * @param toDate
     * @return
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
