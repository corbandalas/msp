
package accomplish;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomField {

    @SerializedName("cdata1")
    @Expose
    private String cdata1;
    @SerializedName("cdata2")
    @Expose
    private String cdata2;

    @SerializedName("cdata3")
    @Expose
    private String cdata3;

    @SerializedName("linkedUserId")
    @Expose
    private String linkedUserId;


    public String getCdata1() {
        return cdata1;
    }

    public void setCdata1(String cdata1) {
        this.cdata1 = cdata1;
    }

    public String getCdata2() {
        return cdata2;
    }

    public void setCdata2(String cdata2) {
        this.cdata2 = cdata2;
    }

    public String getCdata3() {
        return cdata3;
    }

    public void setCdata3(String cdata3) {
        this.cdata3 = cdata3;
    }

    public String getLinkedUserId() {
        return linkedUserId;
    }

    public void setLinkedUserId(String linkedUserId) {
        this.linkedUserId = linkedUserId;
    }
}
