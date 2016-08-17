package dto.customer;

/**
 * API customer card change alias request
 *
 * @author nihilist created 17.08.2016.
 * @since 0.3.0
 */
public class CustomerCardManagementChangeAlias {

    private Long cardID;
    private String alias;

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
