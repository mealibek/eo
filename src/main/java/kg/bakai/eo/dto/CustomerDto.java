package kg.bakai.eo.dto;


import kg.bakai.eo.models.AddressInfo;

import java.time.LocalDate;

public record CustomerDto(
        Long customerId,
        Integer customerTypeId,
        String surname,
        String customerName,
        String otchestvo,
        Byte sex,
        String identificationNumber,
        Integer nationalityId,
        Boolean resident,
        LocalDate dateOfBirth,
        Integer birthCountryId,
        String birthCityName,
        String birthCountryName,
        AddressInfoDto registrationAddress,
        AddressInfoDto residenceAddress
) {}

