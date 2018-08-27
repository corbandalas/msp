package dto.partner;

/**
 * Send sms notification request DTO object
 *
 * @author corbandalas created 27.08.2018.
 * @since 0.6.0
 */
public class SendMessageRequest {

    private String token;
    private int event;

    public SendMessageRequest(String token, int event) {
        this.token = token;
        this.event = event;
    }

    public SendMessageRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }
}
