package dto.payroll;


/**
 * Payroll request card status DTO object
 *
 * @author corbandalas created 11.12.2017.
 * @since 0.7.0
 */
public class PayrollStatusCardRequest {

    private String payrollRequestID;

    public PayrollStatusCardRequest(String payrollRequestID) {
        this.payrollRequestID = payrollRequestID;
    }

    public PayrollStatusCardRequest() {
    }

    public String getPayrollRequestID() {
        return payrollRequestID;
    }

    public void setPayrollRequestID(String payrollRequestID) {
        this.payrollRequestID = payrollRequestID;
    }

    @Override
    public String toString() {
        return "PayrollStatusCardRequest{" +
                "payrollRequestID='" + payrollRequestID + '\'' +
                '}';
    }
}
