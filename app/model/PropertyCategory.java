package model;

/**
 * Property category enumeration
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */
public enum PropertyCategory {

    GPS_INTEGRATION("GPS_INTEGRATION"), EXCHANGE_RATES_INTEGRATION("EXCHANGE_RATES_INTEGRATION"), W2_INTEGRATION("W2_INTEGRATION"), ACCOUNTS("ACCOUNTS"), SMS("SMS"), WORLDPAY_INTEGRATION("WORLDPAY_INTEGRATION");

    private String value;

    PropertyCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
