package dto.partner;

import dto.BaseAPIResponse;
import provider.dto.CardLoadResponse;

/**
 * Load Card response DTO object
 *
 * @author corbandalas created 12.09.2017.
 * @since 0.6.0
 */
public class LoadCardResponse extends BaseAPIResponse {

    private CardLoadResponse cardLoadResponse;

    public LoadCardResponse(String text, String code, CardLoadResponse cardLoadResponse) {
        super(text, code);
        this.cardLoadResponse = cardLoadResponse;
    }

    public CardLoadResponse getCardLoadResponse() {
        return cardLoadResponse;
    }

    public void setCardLoadResponse(CardLoadResponse cardLoadResponse) {
        this.cardLoadResponse = cardLoadResponse;
    }
}
