package dto.customer;

import dto.BaseAPIResponse;

/**
 * API customer DTO WorldPay credit card deposit response
 *
 * @author corbandalas created 24.05.2016.
 * @since 0.2.0
 */
public class CustomerWorldPayCreditCardResponse extends BaseAPIResponse {

    private String url;
    private long totalAmount;

    public CustomerWorldPayCreditCardResponse(String text, String code, String url, long totalAmount) {
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
