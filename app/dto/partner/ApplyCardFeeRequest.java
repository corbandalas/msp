package dto.partner;

/**
 * Apply fee request DTO object
 *
 * @author corbandalas created 04.04.2018.
 * @since 0.6.0
 */
public class ApplyCardFeeRequest {

    private String token;

    private String procCode;

    private double fee;

    public ApplyCardFeeRequest() {
    }

    public ApplyCardFeeRequest(String token, String procCode, double fee) {
        this.token = token;
        this.procCode = procCode;
        this.fee = fee;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}


