package dto.customer;

import dto.BaseAPIResponse;
import provider.dto.CardDetailsResponse;

import java.util.List;

/**
 * Customer card list response DTO object
 *
 * @author corbandalas created 17.02.2016.
 * @since 0.2.0
 */
public class CustomerCardListResponse extends BaseAPIResponse {

    private List<CardWrapper> list;

    public CustomerCardListResponse() {
        super("", "");
    }

    public CustomerCardListResponse(String code, String text, List<CardWrapper> list) {
        super(text, code);
        this.list = list;
    }

    public List<CardWrapper> getList() {
        return list;
    }

    public void setList(List<CardWrapper> list) {
        this.list = list;
    }

    public static class CardWrapper {
        private long id;
        private CardDetailsResponse cardDetails;

        public CardWrapper(long id, CardDetailsResponse cardDetails) {
            this.id = id;
            this.cardDetails = cardDetails;
        }

    }

}
