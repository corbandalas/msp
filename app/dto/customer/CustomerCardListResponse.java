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
        private String alias;
        private String type;
        private String passCode;
        private CardDetailsResponse cardDetails;

        public CardWrapper(long id, String alias, CardDetailsResponse cardDetails, String type, String passCode) {
            this.id = id;
            this.cardDetails = cardDetails;
            this.alias = alias;
            this.type = type;
            this.passCode = passCode;
        }

        public CardWrapper() {

        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public CardDetailsResponse getCardDetails() {
            return cardDetails;
        }

        public void setCardDetails(CardDetailsResponse cardDetails) {
            this.cardDetails = cardDetails;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getPassCode() {
            return passCode;
        }

        public void setPassCode(String passCode) {
            this.passCode = passCode;
        }
    }

}
