package dto.customer;

import dto.BaseAPIResponse;

/**
 * API customer DTO Paylike credit card deposit response
 *
 * @author corbandalas created 02.02.2017.
 * @since 0.4.0
 */
public class CustomerPaylikeCreditCardResponse extends BaseAPIResponse {

    private String url;

    public CustomerPaylikeCreditCardResponse(String text, String code, String url) {
        super(text, code);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
