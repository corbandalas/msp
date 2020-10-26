
package accomplish.dto.account.document;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDocumentResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("documents")
    @Expose
    private List<Document> documents = null;
    @SerializedName("last_activity")
    @Expose
    private LastActivity lastActivity;

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

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public LastActivity getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(LastActivity lastActivity) {
        this.lastActivity = lastActivity;
    }

}
