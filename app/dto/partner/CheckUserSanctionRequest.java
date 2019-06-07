package dto.partner;

/**
 * Check user sanction request DTO object
 *
 * @author corbandalas created 07.06.2019.
 * @since 1.0.0
 */
public class CheckUserSanctionRequest {

    private String fullName;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;

    public CheckUserSanctionRequest() {
    }

    public CheckUserSanctionRequest(String fullName, String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        this.fullName = fullName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
