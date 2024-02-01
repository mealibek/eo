package kg.bakai.eo.dto;

public record AddressInfoDto(
                Long id,
                String postalCode,
                Integer cityId,
                Integer countryId,
                String cityName,
                String street,
                String house,
                String flat) {
}
