
package accomplish.dto.customerget;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security {

    @SerializedName("trust_level")
    @Expose
    private String trustLevel;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("security_code")
    @Expose
    private String securityCode;
    @SerializedName("secret_question_1")
    @Expose
    private String secretQuestion1;
    @SerializedName("secret_answer_1")
    @Expose
    private String secretAnswer1;
    @SerializedName("secret_question_2")
    @Expose
    private String secretQuestion2;
    @SerializedName("secret_answer_2")
    @Expose
    private String secretAnswer2;

    public String getTrustLevel() {
        return trustLevel;
    }

    public void setTrustLevel(String trustLevel) {
        this.trustLevel = trustLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getSecretQuestion1() {
        return secretQuestion1;
    }

    public void setSecretQuestion1(String secretQuestion1) {
        this.secretQuestion1 = secretQuestion1;
    }

    public String getSecretAnswer1() {
        return secretAnswer1;
    }

    public void setSecretAnswer1(String secretAnswer1) {
        this.secretAnswer1 = secretAnswer1;
    }

    public String getSecretQuestion2() {
        return secretQuestion2;
    }

    public void setSecretQuestion2(String secretQuestion2) {
        this.secretQuestion2 = secretQuestion2;
    }

    public String getSecretAnswer2() {
        return secretAnswer2;
    }

    public void setSecretAnswer2(String secretAnswer2) {
        this.secretAnswer2 = secretAnswer2;
    }

}
