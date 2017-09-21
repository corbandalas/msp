package dto.partner;

/**
 * Web service result request DTO object
 *
 * @author corbandalas created 21.09.2017.
 * @since 0.6.0
 */
public class WebServiceResultRequest {

    private String token;

    private String wsid;

    public WebServiceResultRequest(String token, String wsid) {
        this.token = token;
        this.wsid = wsid;
    }

    public WebServiceResultRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWsid() {
        return wsid;
    }

    public void setWsid(String wsid) {
        this.wsid = wsid;
    }
}


