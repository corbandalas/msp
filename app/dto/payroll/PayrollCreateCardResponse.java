package dto.payroll;


import dto.BaseAPIResponse;

/**
 * Payroll create card response DTO object
 *
 * @author corbandalas created 29.09.2017.
 * @since 0.7.0
 */
public class PayrollCreateCardResponse extends BaseAPIResponse {

    private String requestID;

    public PayrollCreateCardResponse() {
        super("", "");
    }

    public PayrollCreateCardResponse(String text, String code, String requestID) {

        super(text, code);

        this.requestID = requestID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
}
