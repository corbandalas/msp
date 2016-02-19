package dto.customer;

/**
 * DTO object for Transfer to another card
 * @author corbandalas created 19.02.2016.
 * @since 0.2.0
 */
public class TransferToAnotherCard {
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
