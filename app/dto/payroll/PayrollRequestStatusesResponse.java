package dto.payroll;


import dto.BaseAPIResponse;
import model.PayrollRequest;

import java.util.List;

/**
 * Payroll create card response DTO object
 *
 * @author corbandalas created 08.12.2017.
 * @since 0.7.0
 */
public class PayrollRequestStatusesResponse extends BaseAPIResponse {

    private List<PayrollRequest> payrollRequestList;

    public PayrollRequestStatusesResponse() {
        super("", "");
    }

    public PayrollRequestStatusesResponse(String text, String code, List<PayrollRequest> payrollRequestList) {

        super(text, code);

        this.payrollRequestList = payrollRequestList;
    }

    public List<PayrollRequest> getPayrollRequestList() {
        return payrollRequestList;
    }

    public void setPayrollRequestList(List<PayrollRequest> payrollRequestList) {
        this.payrollRequestList = payrollRequestList;
    }
}
