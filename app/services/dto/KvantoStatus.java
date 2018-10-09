package services.dto;


public class KvantoStatus {

    private String status;
    private String statuscode;

    public KvantoStatus(String statuscode, String status) {
        this.statuscode = statuscode;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }
}