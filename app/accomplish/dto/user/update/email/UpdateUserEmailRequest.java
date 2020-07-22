
package accomplish.dto.user.update.email;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateUserEmailRequest {

    @SerializedName("email")
    @Expose
    private List<Email> email = null;

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

}
