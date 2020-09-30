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
    private String customerId;
    private CardType type;
    private CardBrand brand;
    private Boolean cardDefault;
    private Date createDate;
    private String alias;
    private Boolean active;
    private String info;
    private String currencyId;
    private String deliveryAddress1;
    private String deliveryAddress2;
    private String deliveryAddress3;
    private String deliveryCountry;
    private String accountID;

    public Card() {
    }

    public Card(Long id, String token, String customerId, CardType type, CardBrand brand, Boolean cardDefault, Date createDate, String alias, Boolean active, String info, String currencyId, String deliveryAddress1, String deliveryAddress2, String deliveryAddress3, String deliveryCountry) {
        this.setId(id);
        this.token = token;
        this.customerId = customerId;
        this.type = type;
        this.brand = brand;
        this.cardDefault = cardDefault;
        this.createDate = createDate;
        this.alias = alias;
        this.active = active;
        this.info = info;
        this.currencyId = currencyId;
        this.deliveryAddress1 = deliveryAddress1;
        this.deliveryAddress2 = deliveryAddress2;
        this.deliveryAddress3 = deliveryAddress3;
        this.deliveryCountry = deliveryCountry;
    }

    public Card(Long id, String token, String customerId, CardType type, CardBrand brand, Boolean cardDefault, Date createDate, String alias, Boolean active, String info, String currencyId, String deliveryAddress1, String deliveryAddress2, String deliveryAddress3, String deliveryCountry, boolean defaultCard) {
        this.setId(id);
        this.token = token;
        this.customerId = customerId;
        this.type = type;
        this.brand = brand;
        this.cardDefault = cardDefault;
        this.createDate = createDate;
        this.alias = alias;
        this.active = active;
        this.info = info;
        this.currencyId = currencyId;
        this.deliveryAddress1 = deliveryAddress1;
        this.deliveryAddress2 = deliveryAddress2;
        this.deliveryAddress3 = deliveryAddress3;
        this.deliveryCountry = deliveryCountry;
        this.cardDefault = defaultCard;
    }

    public Card(Long id, String token, String customerId, CardType type, CardBrand brand, Boolean cardDefault, Date createDate, String alias, Boolean active, String info, String currencyId, String deliveryAddress1, String deliveryAddress2, String deliveryAddress3, String deliveryCountry, String accountID) {
        this.setId(id);
        this.token = token;
        this.customerId = customerId;
        this.type = type;
        this.brand = brand;
        this.cardDefault = cardDefault;
        this.createDate = createDate;
        this.alias = alias;
        this.active = active;
        this.info = info;
        this.currencyId = currencyId;
        this.deliveryAddress1 = deliveryAddress1;
        this.deliveryAddress2 = deliveryAddress2;
        this.deliveryAddress3 = deliveryAddress3;
        this.deliveryCountry = deliveryCountry;
        this.accountID = accountID;
    }

    public Boolean getCardDefault() {
        return cardDefault;
    }

    public void setCardDefault(Boolean cardDefault) {
        this.cardDefault = cardDefault;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
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
                ", customerId=" + customerId +
                ", type=" + type +
                ", brand=" + brand +
                ", cardDefault=" + cardDefault +
                ", createDate=" + createDate +
                ", alias='" + alias + '\'' +
                ", active=" + active +
                ", info='" + info + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", deliveryAddress1='" + deliveryAddress1 + '\'' +
                ", deliveryAddress2='" + deliveryAddress2 + '\'' +
                ", deliveryAddress3='" + deliveryAddress3 + '\'' +
                ", deliveryCountry='" + deliveryCountry + '\'' +
                ", accountID='" + accountID + '\'' +
                '}';
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
