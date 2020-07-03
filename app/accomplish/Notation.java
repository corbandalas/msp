
package accomplish;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notation {

    @SerializedName("notes")
    @Expose
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
