package kg.bakai.eo.dto;

import java.time.LocalDate;

public record BusinessInfoDto(
        Long id,
        Long customerId,
        Integer personActivityTypeId,
        Byte isIndividualEntrepreneur,
        Byte isPrivateEntrepreneur,
        Integer OKPO,
        Integer legalFormId,
        Integer activityTypeId,
        Integer ownershipTypeId,
        Integer taxOfficeId,
        Integer socialRegistrationNo,
        Integer registrationAuthority,
        LocalDate dateOfRegistration
) {
}
