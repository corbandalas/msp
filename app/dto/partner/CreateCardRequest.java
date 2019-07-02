package dto.partner;

/**
 * Create Card request DTO object
 * @author corbandalas created 11.09.2017.
 * @since 0.6.0
 */
public class CreateCardRequest {

    private String currency;
    private String amount;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String postcode;
    private String phone;
    private String dob;
    private String country;
    private String kyc;
    private String cardName;
    private String activateNow;
    private String plastic;
    private String cardDesign;
    private String deliveryAddress1;
    private String deliveryCity;
    private String deliveryPostCode;
    private String deliveryCountry;
    private String deliveryMethod;
    private String smsRequired;
    private String image;
    private String expDate;

    public CreateCardRequest() {

    }

    public CreateCardRequest(String currency, String amount, String title, String firstName, String lastName, String email, String address1, String address2, String city, String postcode, String phone, String dob, String country, String kyc, String cardName, String activateNow, String plastic, String cardDesign, String deliveryAddress1, String deliveryCity, String deliveryPostCode, String deliveryCountry, String deliveryMethod, String image) {
        this.currency = currency;
        this.amount = amount;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.phone = phone;
        this.dob = dob;
        this.country = country;
        this.kyc = kyc;
        this.cardName = cardName;
        this.activateNow = activateNow;
        this.plastic = plastic;
        this.cardDesign = cardDesign;
        this.deliveryAddress1 = deliveryAddress1;
        this.deliveryCity = deliveryCity;
        this.deliveryPostCode = deliveryPostCode;
        this.deliveryCountry = deliveryCountry;
        this.deliveryMethod = deliveryMethod;
        this.image = image;
    }

    public CreateCardRequest(String currency, String amount, String title, String firstName, String lastName, String email, String address1, String address2, String city, String postcode, String phone, String dob, String country, String kyc, String cardName, String activateNow, String plastic, String cardDesign, String image) {
        this.currency = currency;
        this.amount = amount;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.phone = phone;
        this.dob = dob;
        this.country = country;
        this.kyc = kyc;
        this.cardName = cardName;
        this.activateNow = activateNow;
        this.plastic = plastic;
        this.cardDesign = cardDesign;
        this.image = image;
    }

    public CreateCardRequest(String currency, String amount, String title, String firstName, String lastName, String email, String address1, String address2, String city, String postcode, String phone, String dob, String country, String kyc, String cardName, String activateNow, String plastic, String cardDesign, String image, String expDate, String smsRequired) {
        this.currency = currency;
        this.amount = amount;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.phone = phone;
        this.dob = dob;
        this.country = country;
        this.kyc = kyc;
        this.cardName = cardName;
        this.activateNow = activateNow;
        this.plastic = plastic;
        this.cardDesign = cardDesign;
        this.image = image;
        this.expDate = expDate;
        this.smsRequired = smsRequired;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getKyc() {
        return kyc;
    }

    public void setKyc(String kyc) {
        this.kyc = kyc;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getActivateNow() {
        return activateNow;
    }

    public void setActivateNow(String activateNow) {
        this.activateNow = activateNow;
    }

    @Override
    public String toString() {
        return "CreateCard{" +
                "currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                ", dob='" + dob + '\'' +
                ", country='" + country + '\'' +
                ", kyc='" + kyc + '\'' +
                ", cardName='" + cardName + '\'' +
                ", activateNow='" + activateNow + '\'' +
                ", plastic='" + plastic + '\'' +
                ", deliveryAddress1='" + deliveryAddress1 + '\'' +
                ", deliveryCity='" + deliveryCity + '\'' +
                ", deliveryPostCode='" + deliveryPostCode + '\'' +
                ", deliveryCountry='" + deliveryCountry + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                '}';
    }

    public String getPlastic() {
        return plastic;
    }

    public void setPlastic(String plastic) {
        this.plastic = plastic;
    }

    public String getCardDesign() {
        return cardDesign;
    }

    public void setCardDesign(String cardDesign) {
        this.cardDesign = cardDesign;
    }

    public String getDeliveryAddress1() {
        return deliveryAddress1;
    }

    public void setDeliveryAddress1(String deliveryAddress1) {
        this.deliveryAddress1 = deliveryAddress1;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryPostCode() {
        return deliveryPostCode;
    }

    public void setDeliveryPostCode(String deliveryPostCode) {
        this.deliveryPostCode = deliveryPostCode;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getSmsRequired() {
        return smsRequired;
    }

    public void setSmsRequired(String smsRequired) {
        this.smsRequired = smsRequired;
    }
}
