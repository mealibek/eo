package kg.bakai.eo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {
    private String surname;
    private String customerName;
    private String otchestvo;
    private Byte sex;
    private String identificationNumber;
    private Integer nationalityId;
    private Boolean resident;
    private LocalDate dateOfBirth;
    private Integer birthCountryId;
    private String birthCityName;
    private String birthCountryName;
    private AddressInfoDTO registrationAddress;
    private AddressInfoDTO residenceAddress;
}
