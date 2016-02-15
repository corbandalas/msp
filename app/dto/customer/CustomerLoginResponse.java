package dto.customer;

import dto.BaseAPIResponse;

/**
 * Customer authorization response DTO object
 *
 * @author corbandalas created 15.02.2016.
 * @since 0.2.0
 */
public class CustomerLoginResponse extends BaseAPIResponse{

    private String token;

    public CustomerLoginResponse() {
        super("", "");
    }

    public CustomerLoginResponse(String code, String text, String token) {
        super(text, code);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
