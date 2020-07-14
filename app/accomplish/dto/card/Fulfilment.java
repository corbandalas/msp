
package accomplish.dto.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fulfilment {

    @SerializedName("info")
    @Expose
    private Info_ info;
    @SerializedName("card_production")
    @Expose
    private CardProduction cardProduction;
    @SerializedName("courier")
    @Expose
    private Courier courier;

    public Info_ getInfo() {
        return info;
    }

    public void setInfo(Info_ info) {
        this.info = info;
    }

    public CardProduction getCardProduction() {
        return cardProduction;
    }

    public void setCardProduction(CardProduction cardProduction) {
        this.cardProduction = cardProduction;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

}
