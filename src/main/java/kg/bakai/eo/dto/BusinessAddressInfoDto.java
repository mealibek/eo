package kg.bakai.eo.dto;


import java.time.LocalDate;

public record BusinessAddressInfoDto (
        Long id,
        Long customerId,
        Integer businessCityId,
        Integer businessCountryId,
        String businessCityName,
        String businessStreet,
        String businessHouse,
        String businessFlat,
        String businessPostalCode,
        LocalDate startBusinessDate,
        Integer partnersCount
) {}