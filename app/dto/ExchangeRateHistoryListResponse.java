package dto;

import model.ExchangeRateHistory;

import java.util.List;

/**
 * ExchangeRateHistory list API response
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
public class ExchangeRateHistoryListResponse extends BaseAPIResponse {

    private List<ExchangeRateHistory> exchangeRateHistoryList;

    public ExchangeRateHistoryListResponse() {
        super("", "");
    }

    public ExchangeRateHistoryListResponse(String code, String text, List<ExchangeRateHistory> exchangeRateHistoryList) {
        super(text, code);
        this.exchangeRateHistoryList = exchangeRateHistoryList;
    }

    public List<ExchangeRateHistory> getExchangeRateHistoryList() {
        return exchangeRateHistoryList;
    }

    public void setExchangeRateHistoryList(List<ExchangeRateHistory> exchangeRateHistoryList) {
        this.exchangeRateHistoryList = exchangeRateHistoryList;
    }
}
