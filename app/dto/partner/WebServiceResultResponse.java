package dto.partner;

import ae.globalprocessing.hyperionweb.WsResult;
import dto.BaseAPIResponse;

/**
 * Web service result response DTO object
 *
 * @author corbandalas created 21.09.2017.
 * @since 0.6.0
 */
public class WebServiceResultResponse extends BaseAPIResponse {

    private WsResult wsResult;

    public WebServiceResultResponse(String text, String code, WsResult wsResult) {
        super(text, code);
        this.wsResult = wsResult;
    }

    public WsResult getCardUnloadResponse() {
        return wsResult;
    }

    public void setCardUnloadResponse(WsResult wsResult) {
        this.wsResult = wsResult;
    }
}
