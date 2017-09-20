package dto.partner;

/**
 * Card balance request DTO object
 *
 * @author corbandalas created 20.09.2017.
 * @since 0.6.0
 */
public class ChangeStatusRequest {

    private String token;

    private String status;

    private String reason;


    public ChangeStatusRequest() {
    }

    public ChangeStatusRequest(String token, String status, String reason) {

        this.token = token;
        this.status = status;
        this.reason = reason;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}


