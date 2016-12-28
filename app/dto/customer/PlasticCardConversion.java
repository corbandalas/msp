package dto.customer;

/**
 * Plastic card conversion request
 *
 * @author corbandalas created 28.12.2016.
 * @since 0.4.0
 */
public class PlasticCardConversion {

    private Long cardID;

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public Long getCardID() {
        return cardID;
    }

}
