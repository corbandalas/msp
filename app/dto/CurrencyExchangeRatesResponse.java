package dto;

import model.Currency;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Currency exchanger rates service response
 *
 * @author corbandalas - created 06.02.2016
 * @since 0.1.0
 *
 */
public class CurrencyExchangeRatesResponse {

    private String success;
    private String terms;
    private String privacy;
    private long timestamp;
    private String source;
    private Map<String, BigDecimal> quotes;

    public CurrencyExchangeRatesResponse() {
    }


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, BigDecimal> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, BigDecimal> quotes) {
        this.quotes = quotes;
    }

}
