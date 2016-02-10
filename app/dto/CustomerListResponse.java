package dto;

import model.Customer;

import java.util.List;

/**
 * Country list API response
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
public class CustomerListResponse extends BaseAPIResponse {

    private List<Customer> customerList;

    public CustomerListResponse() {
        super("", "");
    }

    public CustomerListResponse(String code, String text, List<Customer> customerList) {
        super(text, code);
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
