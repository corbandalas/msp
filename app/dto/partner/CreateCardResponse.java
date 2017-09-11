package dto.partner;

import dto.BaseAPIResponse;
import provider.dto.CardCreationResponse;

/**
 * Create Card request DTO object
 *
 * @author corbandalas created 11.09.2017.
 * @since 0.6.0
 */

public class CreateCardResponse extends BaseAPIResponse {
    private CardCreationResponse cardCreationResponse;

    public CreateCardResponse(String text, String code, CardCreationResponse cardCreationResponse) {
        super(text, code);
        this.cardCreationResponse = cardCreationResponse;
    }

    public CardCreationResponse getCardCreationResponse() {
        return cardCreationResponse;
    }

    public void setCardCreationResponse(CardCreationResponse cardCreationResponse) {
        this.cardCreationResponse = cardCreationResponse;
    }
}
