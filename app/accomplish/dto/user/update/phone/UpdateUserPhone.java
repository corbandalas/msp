
package accomplish.dto.user.update.phone;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateUserPhone {

    @SerializedName("phone")
    @Expose
    private List<Phone> phone = null;

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

}
