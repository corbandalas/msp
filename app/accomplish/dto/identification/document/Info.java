
package accomplish.dto.identification.document;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("program_id")
    @Expose
    private Integer programId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("entity")
    @Expose
    private Integer entity;
    @SerializedName("entity_id")
    @Expose
    private Integer entityId;
    @SerializedName("document_id")
    @Expose
    private Integer documentId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("number_of_attachments")
    @Expose
    private Integer numberOfAttachments;
    @SerializedName("update_datetime_utc")
    @Expose
    private String updateDatetimeUtc;
    @SerializedName("source_id")
    @Expose
    private String sourceId;
    @SerializedName("server_date")
    @Expose
    private String serverDate;
    @SerializedName("date_utc")
    @Expose
    private String dateUtc;
    @SerializedName("source_time_zone")
    @Expose
    private String sourceTimeZone;

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getNumberOfAttachments() {
        return numberOfAttachments;
    }

    public void setNumberOfAttachments(Integer numberOfAttachments) {
        this.numberOfAttachments = numberOfAttachments;
    }

    public String getUpdateDatetimeUtc() {
        return updateDatetimeUtc;
    }

    public void setUpdateDatetimeUtc(String updateDatetimeUtc) {
        this.updateDatetimeUtc = updateDatetimeUtc;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getServerDate() {
        return serverDate;
    }

    public void setServerDate(String serverDate) {
        this.serverDate = serverDate;
    }

    public String getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(String dateUtc) {
        this.dateUtc = dateUtc;
    }

    public String getSourceTimeZone() {
        return sourceTimeZone;
    }

    public void setSourceTimeZone(String sourceTimeZone) {
        this.sourceTimeZone = sourceTimeZone;
    }

}
