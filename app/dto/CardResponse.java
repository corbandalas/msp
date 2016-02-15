package dto;

import model.Card;

/**
 * Card API response
 *
 * @author nihilist - created 12.02.2016
 * @since 0.1.0
 */
public class CardResponse extends BaseAPIResponse {

    private Card card;

    public CardResponse(String code, String text, Card card) {
        super(text, code);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
