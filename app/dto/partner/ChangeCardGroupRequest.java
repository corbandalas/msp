package dto.partner;

/**
 * Change card group request DTO object
 *
 * @author corbandalas created 04.04.2018.
 * @since 0.6.0
 */
public class ChangeCardGroupRequest {

    private String token;

    private String permGroup;

    private String limitGroup;


    public ChangeCardGroupRequest() {
    }

    public ChangeCardGroupRequest(String token, String permGroup, String limitGroup) {
        this.token = token;
        this.permGroup = permGroup;
        this.limitGroup = limitGroup;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPermGroup() {
        return permGroup;
    }

    public void setPermGroup(String permGroup) {
        this.permGroup = permGroup;
    }

    public String getLimitGroup() {
        return limitGroup;
    }

    public void setLimitGroup(String limitGroup) {
        this.limitGroup = limitGroup;
    }
}


