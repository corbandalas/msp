package dto.partner;

/**
 * Mini statement request DTO object
 *
 * @author corbandalas created 15.09.2017.
 * @since 0.6.0
 */
public class MiniStatementRequest {

    private String token;
    private String startDate;
    private String endDate;

    public MiniStatementRequest() {
    }
    public MiniStatementRequest(String token) {
        this.token = token;
    }

    public MiniStatementRequest(String token, String startDate, String endDate) {
        this.token = token;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
