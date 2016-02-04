package model;

/**
 * Database stored entity for managing accounts across the project
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
public class Account extends BaseEntity<Integer> {

    private String name;
    private Currency currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                '}';
    }
}
