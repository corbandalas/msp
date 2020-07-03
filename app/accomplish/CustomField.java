
package accomplish;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomField {

    @SerializedName("acceptance2")
    @Expose
    private String acceptance2;
    @SerializedName("acceptance")
    @Expose
    private String acceptance;

    public String getAcceptance2() {
        return acceptance2;
    }

    public void setAcceptance2(String acceptance2) {
        this.acceptance2 = acceptance2;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

}
