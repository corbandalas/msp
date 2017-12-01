package model;

/**
 * Payroll request card status enumeration
 *
 * @author corbandalas - created 23.11.2017
 * @since 0.7.0
 */
public enum PayrollCardStatus {

    REQUESTED("REQUESTED"),
    CANCELED("CANCELED"),
    COMPLETED("COMPLETED");

    private String value;

    PayrollCardStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
