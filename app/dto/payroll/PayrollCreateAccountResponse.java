package dto.payroll;

import dto.BaseAPIResponse;

/**
 * Account registration response DTO object
 *
 * @author corbandalas created 17.09.2018.
 * @since 0.7.0
 */
public class PayrollCreateAccountResponse extends BaseAPIResponse {


    public PayrollCreateAccountResponse() {
        super("", "");
    }

    public PayrollCreateAccountResponse(String code, String text) {
        super(text, code);
    }

}
