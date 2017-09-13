package provider.dto;

import ae.globalprocessing.hyperionweb.LoadCard;

/**
 * Card load response
 *
 * @author corbandalas - created 10.02.2016
 * @since 0.1.0
 */
public class CardLoadResponse extends BaseCardResponse{

    private LoadCard loadCard;

    public CardLoadResponse(String actionCode, LoadCard loadCard) {
        super(actionCode);
        this.loadCard = loadCard;
    }
    public CardLoadResponse(String actionCode) {
        super(actionCode);
    }

    public LoadCard getLoadCard() {
        return loadCard;
    }

    public void setLoadCard(LoadCard loadCard) {
        this.loadCard = loadCard;
    }
}
