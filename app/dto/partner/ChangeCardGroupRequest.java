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

    private String mccGroup;

    private String feeGroup;

    private String schedFeeGroup;

    private String wsFeeGroup;

    public ChangeCardGroupRequest() {
    }


    public ChangeCardGroupRequest(String token, String permGroup, String limitGroup, String mccGroup, String feeGroup, String schedFeeGroup, String wsFeeGroup) {
        this.token = token;
        this.permGroup = permGroup;
        this.limitGroup = limitGroup;
        this.mccGroup = mccGroup;
        this.feeGroup = feeGroup;
        this.schedFeeGroup = schedFeeGroup;
        this.wsFeeGroup = wsFeeGroup;
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

    public String getMccGroup() {
        return mccGroup;
    }

    public void setMccGroup(String mccGroup) {
        this.mccGroup = mccGroup;
    }

    public String getFeeGroup() {
        return feeGroup;
    }

    public void setFeeGroup(String feeGroup) {
        this.feeGroup = feeGroup;
    }

    public String getSchedFeeGroup() {
        return schedFeeGroup;
    }

    public void setSchedFeeGroup(String schedFeeGroup) {
        this.schedFeeGroup = schedFeeGroup;
    }

    public String getWsFeeGroup() {
        return wsFeeGroup;
    }

    public void setWsFeeGroup(String wsFeeGroup) {
        this.wsFeeGroup = wsFeeGroup;
    }
}


