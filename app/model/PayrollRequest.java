package model;

import java.util.Date;

/**
 * Database stored entity for managing payroll request data
 *
 * @author corbandalas - created 23.11.2017
 * @since 0.7.0
 */
public class PayrollRequest extends BaseEntity<Long> {

    private String orderId;
    private String description;
    private Date createDate;
    private String daySequence;
    private Integer accountID;
    private PayrollRequestStatus errorStatus;

    public PayrollRequest(Long id, String orderId, String description, Date createDate, String daySequence, Integer accountID, PayrollRequestStatus errorStatus) {
        setId(id);
        this.orderId = orderId;
        this.description = description;
        this.createDate = createDate;
        this.daySequence = daySequence;
        this.accountID = accountID;
        this.errorStatus = errorStatus;
    }

    public PayrollRequest() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "PayrollRequest{" +
                ", orderId='" + orderId + '\'' +
                ", description='" + description + '\'' +
                ", errorStatus='" + errorStatus + '\'' +
                ", daySequence='" + daySequence + '\'' +
                ", accountID='" + accountID + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getDaySequence() {
        return daySequence;
    }

    public void setDaySequence(String daySequence) {
        this.daySequence = daySequence;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public void setErrorStatus(PayrollRequestStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

    public PayrollRequestStatus getErrorStatus() {
        return this.errorStatus;
    }

}
