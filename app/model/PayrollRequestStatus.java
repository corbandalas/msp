package model;

/**
 * Payroll request status enumeration
 *
 * @author corbandalas - created 23.11.2017
 * @since 0.7.0
 */
public enum PayrollRequestStatus {

    PROCESSED("PROCESSED"),
    NOT_PROCESSED("NOT_PROCESSED");

    private String value;

    PayrollRequestStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
