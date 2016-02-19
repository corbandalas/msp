package dto.customer;

/**
 * API customer transfer between own cards request
 * @author ra created 19.02.2016.
 * @since 0.1.0
 */
public class TransferOwnCards {
    private Long cardFrom;
    private Long cardTo;

    public Long getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(Long cardFrom) {
        this.cardFrom = cardFrom;
    }

    public Long getCardTo() {
        return cardTo;
    }

    public void setCardTo(Long cardTo) {
        this.cardTo = cardTo;
    }
}
