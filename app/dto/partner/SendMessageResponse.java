package dto.partner;

import ae.globalprocessing.hyperionweb.AlertResponse;
import dto.BaseAPIResponse;

/**
 * Card Balance adjustment response DTO object
 *
 * @author corbandalas created 24.08.2018.
 * @since 0.6.0
 */

public class SendMessageResponse extends BaseAPIResponse {

    private AlertResponse alertResponse;

    public SendMessageResponse(String text, String code, AlertResponse alertResponse) {
        super(text, code);
        this.alertResponse = alertResponse;
    }

    public AlertResponse getAlertResponse() {
        return alertResponse;
    }

    public void setAlertResponse(AlertResponse alertResponse) {
        this.alertResponse = alertResponse;
    }
}
