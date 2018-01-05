package provider.dto;

/**
 * Change PIN response
 *
 * @author corbandalas - created 19.02.2016
 * @since 0.2.0
 */
public class ChangePINResponse extends BaseCardResponse {

    private String pin;

    public ChangePINResponse(String actionCode) {
        super(actionCode);
    }

    public ChangePINResponse(String actionCode, String pin) {
        super(actionCode);
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
