package dto;

import model.Currency;

/**
 * Currency API response
 *
 * @author nihilist - created 09.02.2016
 * @since 0.1.0
 */
public class CurrencyResponse extends BaseAPIResponse {

    private Currency currency;

    public CurrencyResponse(String text, String code, Currency currency) {
        super(text, code);
        this.currency = currency;
    }


    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
