package dto.payroll;


import dto.BaseAPIResponse;
import model.PayrollCard;

import java.util.List;

/**
 * Payroll create card response DTO object
 *
 * @author corbandalas created 11.12.2017.
 * @since 0.7.0
 */
public class PayrollRequestCardStatusesResponse extends BaseAPIResponse {

    private List<PayrollCard> payrollCards;

    public PayrollRequestCardStatusesResponse() {
        super("", "");
    }

    public PayrollRequestCardStatusesResponse(String text, String code, List<PayrollCard> payrollCards) {

        super(text, code);

        this.payrollCards = payrollCards;
    }

    public List<PayrollCard> getPayrollCards() {
        return payrollCards;
    }

    public void setPayrollCards(List<PayrollCard> payrollCards) {
        this.payrollCards = payrollCards;
    }
}
