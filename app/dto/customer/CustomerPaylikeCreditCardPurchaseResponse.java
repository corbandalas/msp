package dto.customer;

import dto.BaseAPIResponse;

/**
 * API customer DTO Paylike credit card purchase response
 *
 * @author corbandalas created 02.02.2017.
 * @since 0.4.0
 */
public class CustomerPaylikeCreditCardPurchaseResponse extends BaseAPIResponse {

    private String url;
    private long totalAmount;

    public CustomerPaylikeCreditCardPurchaseResponse(String text, String code, String url, long totalAmount) {
        super(text, code);
        this.url = url;
        this.totalAmount = totalAmount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

}
