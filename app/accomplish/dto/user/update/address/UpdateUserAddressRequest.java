
package accomplish.dto.user.update.address;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateUserAddressRequest {

    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
