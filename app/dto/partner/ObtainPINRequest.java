package dto.partner;

/**
 * Card PIN request DTO object
 *
 * @author corbandalas created 18.09.2017.
 * @since 0.6.0
 */
public class ObtainPINRequest {

    private String token;

    public ObtainPINRequest() {
    }
    public ObtainPINRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
