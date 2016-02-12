package provider.dto;

/**
 * Card activation by phone response
 *
 * @author corbandalas - created 10.02.2016
 * @since 0.1.0
 */
public class PhoneActivateResponse extends BaseCardResponse{

    private boolean isLive;
    private String  pinBlock;
    private String pinStatus;

    public PhoneActivateResponse(String actionCode, boolean isLive, String pinBlock, String pinStatus) {

        super(actionCode);
        this.isLive = isLive;
        this.pinBlock = pinBlock;
        this.pinStatus = pinStatus;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public String getPinBlock() {
        return pinBlock;
    }

    public void setPinBlock(String pinBlock) {
        this.pinBlock = pinBlock;
    }

    public String getPinStatus() {
        return pinStatus;
    }

    public void setPinStatus(String pinStatus) {
        this.pinStatus = pinStatus;
    }
}
