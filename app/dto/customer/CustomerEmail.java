package dto.customer;

/**
 * Customer email retrieval request DTO object
 *
 * @author corbandalas created 10.04.2018.
 * @since 0.6.0
 */
public class CustomerEmail {

    private String phone;

    public CustomerEmail() {
    }

    public CustomerEmail(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
