package kg.bakai.eo.dto;

import java.time.LocalDate;

public record PersonalInfoDto(
        Long id,
        Long customerId,
        Integer familyStatusId,
        Integer educationTypeId,
        Byte workTypeId,
        String businessAddressRemarks,
        Byte useBankClient,
        Integer activityNote,
        LocalDate firstRegistrationDate,
        Integer evidenceRegistrationNo,
        Byte isPoliticalPerson,
        Integer politicalCountryId,
        Integer politicalPositionId
) {
}
