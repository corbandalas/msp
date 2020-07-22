package accomplish.dto.user.update.address.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateUserAddressResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("address")
    @Expose
    private Address address;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}