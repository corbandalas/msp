
package accomplish.dto.identification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateIdentification {

    @SerializedName("identification")
    @Expose
    private List<Identification> identification = null;

    public List<Identification> getIdentification() {
        return identification;
    }

    public void setIdentification(List<Identification> identification) {
        this.identification = identification;
    }

}
