package dto.partner;

public enum ChangeCardStatus {

    BLOCK("05"), ACTIVATE("00"), REPORT_LOST("41"), REPORT_STOLEN("43"), REPORT_DAMAGED("83");

    private String value;


    ChangeCardStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}