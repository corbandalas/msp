package dto;


/**
 * Currency exchange API response
 *
 * @author nihilist - created 11.02.2016
 * @since 0.1.0
 */
public class CurrencyExchangeResponse extends BaseAPIResponse {

    private String currencyFrom;
    private String currencyTo;
    private long initialAmount;
    private long resultAmount;

    public CurrencyExchangeResponse(String code, String text, String currencyFrom, String currencyTo, long initialAmount, long resultAmount) {
        super(text, code);
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.initialAmount = initialAmount;
        this.resultAmount = resultAmount;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public long getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(long initialAmount) {
        this.initialAmount = initialAmount;
    }

    public long getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(long resultAmount) {
        this.resultAmount = resultAmount;
    }
}
