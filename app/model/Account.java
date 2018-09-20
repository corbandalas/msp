package model;

import java.util.Date;

/**
 * Database stored entity for managing accounts across the project
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
public class Account extends BaseEntity<Integer> {

    private String name;
    private String currencyId;
    private Date createDate;
    private Boolean active;
    private String secret;
    private Long cardId;

    public Account(Integer id, String name, String currencyId, Date createDate, Boolean active, String secret) {
        this.setId(id);
        this.name = name;
        this.currencyId = currencyId;
        this.createDate = createDate;
        this.active = active;
        this.secret = secret;
    }

    public Account(Integer id, String name, String currencyId, Date createDate, Boolean active, String secret, Long cardId) {
        this.setId(id);
        this.name = name;
        this.currencyId = currencyId;
        this.createDate = createDate;
        this.active = active;
        this.secret = secret;
        this.cardId = cardId;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", createDate=" + createDate +
                ", active=" + active +
                '}';
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}
