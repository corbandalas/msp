package dto;

import model.Customer;

/**
 * Country API response
 *
 * @author nihilist - created 09.02.2016
 * @since 0.1.0
 */
public class CustomerResponse extends BaseAPIResponse {

    private Customer customer;

    public CustomerResponse(String text, String code, Customer customer) {
        super(text, code);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
