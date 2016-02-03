package model;

import model.enums.CardBrand;
import model.enums.CardType;

import java.util.Date;

/**
 * Database stored entity for managing cards across the project
 *
 * @author ra - created 03.02.2016
 * @since 0.1.0
 */
public class Card extends BaseEntity<Long> {

    private String token;
    private Customer customer;
    private CardType type;
    private CardBrand brand;
    private Date createDate;
    private String alias;
    private Boolean active;
    private String info;
    private Currency currency;
    private String deliveryAddress1;
    private String deliveryAddress2;
    private String deliveryAddress3;
    private String deliveryCountry;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardBrand getBrand() {
        return brand;
    }

    public void setBrand(CardBrand brand) {
        this.brand = brand;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getDeliveryAddress1() {
        return deliveryAddress1;
    }

    public void setDeliveryAddress1(String deliveryAddress1) {
        this.deliveryAddress1 = deliveryAddress1;
    }

    public String getDeliveryAddress2() {
        return deliveryAddress2;
    }

    public void setDeliveryAddress2(String deliveryAddress2) {
        this.deliveryAddress2 = deliveryAddress2;
    }

    public String getDeliveryAddress3() {
        return deliveryAddress3;
    }

    public void setDeliveryAddress3(String deliveryAddress3) {
        this.deliveryAddress3 = deliveryAddress3;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    @Override
    public String toString() {
        return "Card{" +
                "token='" + token + '\'' +
                ", customer=" + customer +
                ", type=" + type +
                ", brand=" + brand +
                ", createDate=" + createDate +
                ", alias='" + alias + '\'' +
                ", active=" + active +
                ", info='" + info + '\'' +
                ", currency=" + currency +
                ", deliveryAddress1='" + deliveryAddress1 + '\'' +
                ", deliveryAddress2='" + deliveryAddress2 + '\'' +
                ", deliveryAddress3='" + deliveryAddress3 + '\'' +
                ", deliveryCountry='" + deliveryCountry + '\'' +
                '}';
    }
}
