package dto.partner;

import ae.globalprocessing.hyperionweb.LoadCard;
import dto.BaseAPIResponse;

/**
 * Load Card response DTO object
 *
 * @author corbandalas created 12.09.2017.
 * @since 0.6.0
 */
public class LoadCardResponse extends BaseAPIResponse {

    private ae.globalprocessing.hyperionweb.LoadCard loadCard;

    public LoadCardResponse(String text, String code, ae.globalprocessing.hyperionweb.LoadCard loadCard) {
        super(text, code);
        this.loadCard = loadCard;
    }

    public ae.globalprocessing.hyperionweb.LoadCard getLoadCard() {
        return loadCard;
    }

    public void setLoadCard(LoadCard loadCard) {
        this.loadCard = loadCard;
    }
}
