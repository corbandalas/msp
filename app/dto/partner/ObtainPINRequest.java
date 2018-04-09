package dto.partner;

/**
 * Card PIN request DTO object
 *
 * @author corbandalas created 18.09.2017.
 * @since 0.6.0
 */
public class ObtainPINRequest {

    private String token;
    private String feeWaiver;
    private String func;

    public ObtainPINRequest() {
    }
    public ObtainPINRequest(String token) {
        this.token = token;
    }

    public ObtainPINRequest(String token, String feeWaiver, String func) {
        this.token = token;
        this.feeWaiver = feeWaiver;
        this.func = func;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFeeWaiver() {
        return feeWaiver;
    }

    public void setFeeWaiver(String feeWaiver) {
        this.feeWaiver = feeWaiver;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }
}
