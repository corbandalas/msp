package dto.payroll;


import dto.BaseAPIResponse;

/**
 * Payroll create card response DTO object
 *
 * @author corbandalas created 29.09.2018.
 * @since 0.7.0
 */
public class PayrollAccountBalanceResponse extends BaseAPIResponse {

    private Double balance;
    private String currency;

    public PayrollAccountBalanceResponse() {
        super("", "");
    }

    public PayrollAccountBalanceResponse(String text, String code, Double balance, String currency) {

        super(text, code);

        this.balance = balance;
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
