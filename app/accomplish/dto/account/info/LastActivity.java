
package accomplish.dto.account.info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastActivity {

    @SerializedName("entity")
    @Expose
    private Integer entity;
    @SerializedName("entity_id")
    @Expose
    private Integer entityId;
    @SerializedName("entity_data")
    @Expose
    private Integer entityData;
    @SerializedName("activity_type")
    @Expose
    private Integer activityType;
    @SerializedName("notes")
    @Expose
    private Notes notes;
    @SerializedName("update_date_utc")
    @Expose
    private String updateDateUtc;

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

    public Integer getEntityData() {
        return entityData;
    }

    public void setEntityData(Integer entityData) {
        this.entityData = entityData;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public String getUpdateDateUtc() {
        return updateDateUtc;
    }

    public void setUpdateDateUtc(String updateDateUtc) {
        this.updateDateUtc = updateDateUtc;
    }

}
