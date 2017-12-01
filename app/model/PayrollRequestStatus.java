package model;

/**
 * Payroll request status enumeration
 *
 * @author corbandalas - created 23.11.2017
 * @since 0.7.0
 */
public enum PayrollRequestStatus {

    REQUESTED("REQUESTED"),
    CANCELED("CANCELED"),
    COMPLETED("COMPLETED");

    private String value;

    PayrollRequestStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
