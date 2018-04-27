package dto;

/**
 * Base API response
 *
 * @author corbandalas - created 01.02.2016
 * @since 0.1.0
 *
 */
public class BaseAPIResponse {

    private String text;
    private String code;
    private String errorCode;

    public BaseAPIResponse(String text, String code) {
        this.text = text;
        this.code = code;
    }

    public BaseAPIResponse(String text, String code, String errorCode) {
        this.text = text;
        this.code = code;
        this.errorCode = errorCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseAPIResponse{" +
                "text='" + text + '\'' +
                ", code='" + code + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
