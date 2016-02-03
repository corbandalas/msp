package model;

/**
 * Database stored entity for managing currencies across the project
 *
 * Entity id - currency ISO-4217 3 letter code like USD, EUR. https://en.wikipedia.org/wiki/ISO_4217
 *
 * @author ra - created 03.02.2016
 * @since 0.1.0
 *
 */
public class Currency extends BaseEntity<String> {

    private Short code;
    private String displayText;
    private Double euroIndex;
    private Boolean active;

    /**
     * Get currency ISO-4217 3 digit numeric code
     * @return code
     */
    public Short getCode() {
        return code;
    }

    /**
     * Set currency ISO-4217 3 digit numeric code
     * @param code
     */
    public void setCode(Short code) {
        this.code = code;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public Double getEuroIndex() {
        return euroIndex;
    }

    public void setEuroIndex(Double euroIndex) {
        this.euroIndex = euroIndex;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code=" + code +
                ", displayText='" + displayText + '\'' +
                ", euroIndex=" + euroIndex +
                ", active=" + active +
                '}';
    }
}
