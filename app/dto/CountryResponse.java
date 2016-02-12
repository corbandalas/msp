package dto;

import model.Country;

/**
 * Country API response
 *
 * @author nihilist - created 09.02.2016
 * @since 0.1.0
 */
public class CountryResponse extends BaseAPIResponse {

    private Country country;

    public CountryResponse(String code, String text, Country country) {
        super(text, code);
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
