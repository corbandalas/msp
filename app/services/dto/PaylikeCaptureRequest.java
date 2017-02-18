package services.dto;

/**
 * Paylike gateway capture request DTO
 *
 * @author corbandalas - created 02.02.2017
 * @since 0.4.0
 */
public class PaylikeCaptureRequest {

    private Long amount;
    private String currency;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
