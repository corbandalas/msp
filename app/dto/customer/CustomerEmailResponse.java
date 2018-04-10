package dto.customer;

import dto.BaseAPIResponse;

import java.util.List;

/**
 * Customer email retrieval response DTO object
 *
 * @author corbandalas created 10.04.2018.
 * @since 0.6.0
 */
public class CustomerEmailResponse extends BaseAPIResponse {

    private String email;

    public CustomerEmailResponse(String text, String code) {
        super(text, code);
    }

    public CustomerEmailResponse(String text, String code, String email) {
        super(text, code);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
