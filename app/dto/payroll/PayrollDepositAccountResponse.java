package dto.payroll;

import dto.BaseAPIResponse;

/**
 * Account registration response DTO object
 *
 * @author corbandalas created 17.09.2018.
 * @since 0.7.0
 */
public class PayrollDepositAccountResponse extends BaseAPIResponse {


    public PayrollDepositAccountResponse() {
        super("", "");
    }

    public PayrollDepositAccountResponse(String code, String text) {
        super(text, code);
    }

}
