package kg.bakai.eo.dto;

public record ContactInformationDto(
        Long id,
        Long customerId,
        String contactPhone1,
        String contactPhone2,
        String contactAddress,
        String contactPerson,
        String contactPersonPhone,
        String email
) {
}
