package dto.payroll;


import dto.BaseAPIResponse;

/**
 * Payroll create card response DTO object
 *
 * @author corbandalas created 29.09.2017.
 * @since 0.7.0
 */
public class PayrollCreateCardResponse extends BaseAPIResponse {


    public PayrollCreateCardResponse() {
        super("", "");
    }

    public PayrollCreateCardResponse(String text, String code) {

        super(text, code);
    }

}
