package model;

/**
 * Payroll card type enumeration
 *
 * @author corbandalas - created 08.12.2017
 * @since 0.7.0
 */
public enum PayrollCardType {

    CARD_CREATION("CARD_CREATION"),
    CARD_DEPOSIT("CARD_DEPOSIT");

    private String value;

    PayrollCardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
