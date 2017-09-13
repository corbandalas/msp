package provider.dto;

import ae.globalprocessing.hyperionweb.UnLoad;

/**
 * Card unload response
 *
 * @author corbandalas - created 11.02.2016
 * @since 0.1.0
 */
public class CardUnloadResponse extends BaseCardResponse{

    private UnLoad unloadCard;

    public CardUnloadResponse(String actionCode) {
        super(actionCode);
    }

    public CardUnloadResponse(String actionCode, UnLoad unloadCard) {
        super(actionCode);
        this.unloadCard = unloadCard;
    }

    public UnLoad getUnloadCard() {
        return unloadCard;
    }

    public void setUnloadCard(UnLoad unloadCard) {
        this.unloadCard = unloadCard;
    }
}
