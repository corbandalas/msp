package dto.customer;

import dto.BaseAPIResponse;

/**
 * Plastic card activation response
 *
 * @author corbandalas created 05.01.2018.
 * @since 0.5.0
 */
public class PlasticCardActivationResponse extends BaseAPIResponse {

    private String pin;

    public PlasticCardActivationResponse(String text, String code, String pin) {
        super(text, code);
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
