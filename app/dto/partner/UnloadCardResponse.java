package dto.partner;

import dto.BaseAPIResponse;
import provider.dto.CardLoadResponse;
import provider.dto.CardUnloadResponse;

/**
 * UnloadLoad Card response DTO object
 *
 * @author corbandalas created 12.09.2017.
 * @since 0.6.0
 */
public class UnloadCardResponse extends BaseAPIResponse {

    private CardUnloadResponse cardUnloadResponse;

    public UnloadCardResponse(String text, String code, CardUnloadResponse cardUnloadResponse) {
        super(text, code);
        this.cardUnloadResponse = cardUnloadResponse;
    }

    public CardUnloadResponse getCardUnloadResponse() {
        return cardUnloadResponse;
    }

    public void setCardUnloadResponse(CardUnloadResponse cardUnloadResponse) {
        this.cardUnloadResponse = cardUnloadResponse;
    }
}
