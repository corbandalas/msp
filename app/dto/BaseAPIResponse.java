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

    public BaseAPIResponse(String text, String code) {
        this.text = text;
        this.code = code;
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
                '}';
    }
}
