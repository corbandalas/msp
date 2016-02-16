package dto.customer;

import dto.BaseAPIResponse;

/**
 * Customer authorization response DTO object
 *
 * @author corbandalas created 15.02.2016.
 * @since 0.2.0
 */
public class CustomerLoginResponse extends BaseAPIResponse {

    private String token;
    private boolean needChangePassword;

    public CustomerLoginResponse() {
        super("", "");
    }

    public CustomerLoginResponse(String code, String text, String token, boolean needChangePassword) {
        super(text, code);
        this.token = token;
        this.needChangePassword = needChangePassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(boolean needChangePassword) {
        this.needChangePassword = needChangePassword;
    }
}
