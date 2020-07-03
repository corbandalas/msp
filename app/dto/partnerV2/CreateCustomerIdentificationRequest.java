package dto.partnerV2;

/**
 * Create customer identification request DTO object
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */
public class CreateCustomerIdentificationRequest {

    private String userID;
    private String issuanceCountry;
    private String residenceCountry;
    private String issueDate;
    private String expiryDate;
    private String type;
    private String number;


    public CreateCustomerIdentificationRequest() {

    }

    public CreateCustomerIdentificationRequest(String userID, String issuanceCountry, String residenceCountry, String issueDate, String expiryDate, String type, String number) {
        this.userID = userID;
        this.issuanceCountry = issuanceCountry;
        this.residenceCountry = residenceCountry;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.type = type;
        this.number = number;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getIssuanceCountry() {
        return issuanceCountry;
    }

    public void setIssuanceCountry(String issuanceCountry) {
        this.issuanceCountry = issuanceCountry;
    }

    public String getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
