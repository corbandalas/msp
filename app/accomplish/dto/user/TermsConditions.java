
package accomplish.dto.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TermsConditions {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("acceptance")
    @Expose
    private String acceptance;
    @SerializedName("title")
    @Expose
    private Object title;
    @SerializedName("version_name")
    @Expose
    private Object versionName;
    @SerializedName("server_date")
    @Expose
    private Object serverDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getVersionName() {
        return versionName;
    }

    public void setVersionName(Object versionName) {
        this.versionName = versionName;
    }

    public Object getServerDate() {
        return serverDate;
    }

    public void setServerDate(Object serverDate) {
        this.serverDate = serverDate;
    }

}
