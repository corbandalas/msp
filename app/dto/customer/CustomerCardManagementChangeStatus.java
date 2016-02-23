package dto.customer;

/**
 * API customer card change status request
 *
 * @author nihilist created 23.02.2016.
 * @since 0.1.0
 */
public class CustomerCardManagementChangeStatus {

    private Long cardID;
    private String reason;
    private Integer operation;

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }
}
