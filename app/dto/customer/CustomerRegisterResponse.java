package dto.customer;

import dto.BaseAPIResponse;

/**
 * Customer registration response DTO object
 *
 * @author corbandalas created 15.02.2016.
 * @since 0.2.0
 */
public class CustomerRegisterResponse extends BaseAPIResponse {


    public CustomerRegisterResponse() {
        super("", "");
    }

    public CustomerRegisterResponse(String code, String text) {
        super(text, code);
    }

}
