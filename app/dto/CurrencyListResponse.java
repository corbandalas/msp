package dto;

import model.Currency;

import java.util.List;

/**
 * Currency list API response
 * @author ra - created 06.02.2016.
 * @since 0.1.0
 */
public class CurrencyListResponse extends  BaseAPIResponse {

    private List<Currency> currencyList;

    public CurrencyListResponse(String code, String text, List<Currency> currencyList) {
        super(text, code);
        this.currencyList=currencyList;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
