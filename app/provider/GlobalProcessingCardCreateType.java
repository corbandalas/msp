package provider;

/**
 * GPS Card create type enumeration
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 */
public enum GlobalProcessingCardCreateType {

    VIRTUAL_WITH_AMOUNT(0), PHYSICAL_WITH_AMOUNT(1), VIRTUAL_TO_PLASTIC(2), MASTER_VIRTUAL(3);

    private int value;

    GlobalProcessingCardCreateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
