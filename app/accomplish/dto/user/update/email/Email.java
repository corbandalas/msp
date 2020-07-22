
package accomplish.dto.user.update.email;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Email {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("verification_status")
    @Expose
    private Integer verificationStatus;

    @SerializedName("address")
    @Expose
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
