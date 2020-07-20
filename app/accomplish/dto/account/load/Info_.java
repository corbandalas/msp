
package accomplish.dto.account.load;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info_ {

    @SerializedName("id")
    @Expose
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
