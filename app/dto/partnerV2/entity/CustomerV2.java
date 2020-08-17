package dto.partnerV2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerV2 {

    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String mobilePhone;
    private String nationality;
    private String kycLevel;
    private String country;
    private String address1;
    private String address2;
    private String city;
    private String zip;

}