package model;

import java.util.Date;

/**
 * Database stored entity for managing exchange rate history across the project
 *
 * @author ra - created 05.02.2016
 * @since 0.1.0
 */
public class ExchangeRateHistory extends BaseEntity<Long> {

    private Double euroIndex;
    private Date date;
    private String currencyId;

    public ExchangeRateHistory(Long id, Double euroIndex, Date date, String currencyId) {
        setId(id);
        this.euroIndex = euroIndex;
        this.date = date;
        this.currencyId = currencyId;
    }

    public Double getEuroIndex() {
        return euroIndex;
    }

    public void setEuroIndex(Double euroIndex) {
        this.euroIndex = euroIndex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public String toString() {
        return "ExchangeRateHistory{" +
                "euroIndex=" + euroIndex +
                ", date=" + date +
                ", currencyId='" + currencyId + '\'' +
                '}';
    }
}
