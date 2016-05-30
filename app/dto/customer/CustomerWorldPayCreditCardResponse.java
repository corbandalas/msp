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
    private String orderKey;

    public CustomerWorldPayCreditCardResponse(String text, String code, String url, long totalAmount, String orderKey) {
        super(text, code);
        this.url = url;
        this.totalAmount = totalAmount;
        this.orderKey = orderKey;
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

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }
}
