package dto.partner;

import ae.globalprocessing.hyperionweb.PINControl;
import dto.BaseAPIResponse;

/**
 * Card Balance response DTO object
 *
 * @author corbandalas created 18.09.2017.
 * @since 0.6.0
 */

public class ObtainPINResponse extends BaseAPIResponse {

    private PINControl pinControl;

    public ObtainPINResponse(String text, String code, PINControl pinControl) {
        super(text, code);
        this.pinControl = pinControl;
    }

    public PINControl getPinControl() {
        return pinControl;
    }

    public void setPinControl(PINControl pinControl) {
        this.pinControl = pinControl;
    }
}
