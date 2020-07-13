
package accomplish.dto.customerget;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommerceInfo {

    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
