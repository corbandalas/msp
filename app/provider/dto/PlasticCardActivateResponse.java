package provider.dto;

/**
 * Plastic card activation response
 *
 * @author corbandalas - created 15.06.2016
 * @since 0.3.0
 */
public class PlasticCardActivateResponse extends BaseCardResponse{

    private boolean isLive;

    public PlasticCardActivateResponse(String actionCode, boolean isLive) {

        super(actionCode);
        this.isLive = isLive;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

}
