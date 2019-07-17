package dto.partner;

/**
 * Send regenerate request DTO object
 *
 * @author corbandalas created 17.07.2019.
 * @since 0.6.0
 */
public class RegenerateRequest {

    private String token;
    private String smsRequired;

    public RegenerateRequest(String token, String smsRequired) {
        this.token = token;
        this.smsRequired = smsRequired;
    }

    public RegenerateRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSmsRequired() {
        return smsRequired;
    }

    public void setSmsRequired(String smsRequired) {
        this.smsRequired = smsRequired;
    }
}
