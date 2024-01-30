package kg.bakai.eo.dto;

import java.time.LocalDate;

public record DocumentInfoDto(
        Long id,
        Long customerId,
        Integer documentTypeId,
        String documentSeries,
        String documentNo,
        LocalDate issueDate,
        String issueAuthority,
        LocalDate documentValidTill
) {
}
