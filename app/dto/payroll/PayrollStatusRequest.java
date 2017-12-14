package dto.payroll;


/**
 * Payroll request status DTO object
 *
 * @author corbandalas created 08.12.2017.
 * @since 0.7.0
 */
public class PayrollStatusRequest {

    private String accountID;

    public PayrollStatusRequest() {
    }

    public PayrollStatusRequest(String accountID) {
        this.accountID = accountID;
    }


    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
