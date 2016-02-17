package dto.customer;

import dto.BaseAPIResponse;

/**
 * Customer card balance response DTO object
 *
 * @author corbandalas created 17.02.2016.
 * @since 0.2.0
 */
public class CustomerCardBalanceResponse extends BaseAPIResponse {

    private double availableBalance;
    private String currency;

    public CustomerCardBalanceResponse() {
        super("", "");
    }

    public CustomerCardBalanceResponse(String code, String text, double availableBalance, String currency) {
        super(text, code);
        this.availableBalance = availableBalance;
        this.currency = currency;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
