package dto;

import model.Card;
import model.Customer;

import java.util.List;

/**
 * Card list API response
 *
 * @author nihilist - created 12.02.2016.
 * @since 0.1.0
 */
public class CardListResponse extends BaseAPIResponse {

    private List<Card> cardList;

    public CardListResponse() {
        super("", "");
    }

    public CardListResponse(String code, String text, List<Card> cardList) {
        super(text, code);
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
