package provider.dto;

/**
 * Base Card API response
 *
 * @author corbandalas - created 10.02.2016
 * @since 0.1.0
 */
public class BaseCardResponse {

    public BaseCardResponse() {

    }

    private String actionCode;

    public BaseCardResponse(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
}
