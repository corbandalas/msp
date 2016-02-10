package provider.dto;

/**
 * Card balance response
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 */
public class CardBalanceResponse extends BaseCardResponse{

    private double availableBalance;
    private String currency;


    public CardBalanceResponse(double availableBalance, String currency, String actionCode) {
        super(actionCode);
        this.availableBalance = availableBalance;
        this.currency = currency;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
