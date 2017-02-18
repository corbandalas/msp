package services.dto;

/**
 * Paylike gateway refund request DTO
 *
 * @author corbandalas - created 04.02.2017
 * @since 0.4.0
 */
public class PaylikeRefundRequest {

    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
