package dto.partnerV2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create customer request DTO object
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {

    private String email;
    private String title;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/YYYY")
    private String birthdayDate;
    private String mobilePhone;
    private String nationality;
    private String kycLevel;
    private String address1;
    private String address2;
    private String city;
    private String zip;
    private String country;
    private String lang;
    private String password;
    private String cdata1;
    @JsonRawValue
    private Object cdata2;
    private String cdata3;

    private String currency;

}
