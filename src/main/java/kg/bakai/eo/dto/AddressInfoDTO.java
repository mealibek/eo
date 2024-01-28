package kg.bakai.eo.dto;

import lombok.Data;

@Data
public class AddressInfoDTO {
    private String postalCode;
    private Integer cityId;
    private Integer countryId;
    private String cityName;
    private String street;
    private String house;
    private String flat;
}
