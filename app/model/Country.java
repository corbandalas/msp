package model;

/**
 * Database stored entity for managing countries across the project
 *
 * Entity id - country ISO_3166-1 2 letter code like US, RU. https://en.wikipedia.org/wiki/ISO_3166-1
 *
 * @author ra - created 03.02.2016
 * @since 0.1.0
 */
public class Country extends BaseEntity<String> {

    private String name;
    private Short phoneCode;
    private Boolean active;
    private Currency currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get international country phone code
     * @return international country phone code
     */
    public Short getPhoneCode() {
        return phoneCode;
    }

    /**
     * Set international country phone code
     * @param phoneCode international country phone code
     */
    public void setPhoneCode(Short phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", phoneCode=" + phoneCode +
                ", active=" + active +
                ", currency=" + currency +
                '}';
    }
}
