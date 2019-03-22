package dto.partner;

/**
 * Send extend exp date request DTO object
 *
 * @author corbandalas created 20.03.2019.
 * @since 0.6.0
 */
public class ExtendExpDateRequest {

    private String token;
    private String expDate;

    public ExtendExpDateRequest(String token, String expDate) {
        this.token = token;
        this.expDate = expDate;
    }

    public ExtendExpDateRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
