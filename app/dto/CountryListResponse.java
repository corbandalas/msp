package dto;

import model.Country;

import java.util.List;

/**
 * Country list API response
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
public class CountryListResponse extends BaseAPIResponse {

    private List<Country> countryList;

    public CountryListResponse() {
        super("", "");
    }

    public CountryListResponse(String code, String text, List<Country> countryList) {
        super(text, code);
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
