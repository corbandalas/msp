
package accomplish.dto.identification.document;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment {

    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("file_extension")
    @Expose
    private String fileExtension;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("file_id")
    @Expose
    private Integer fileId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

}
