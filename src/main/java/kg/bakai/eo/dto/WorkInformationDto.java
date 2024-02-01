package kg.bakai.eo.dto;

import java.time.LocalDate;

public record WorkInformationDto(
        Long id,
        Long customerId,
        String workName,
        String workPosition,
        String workPhone,
        Integer employeesCount,
        Integer workSalary,
        Integer workCurrencyId,
        Integer workAddress,
        LocalDate workStartDate,
        LocalDate workTotalStartDate,
        Boolean hasExtraWork,
        String extraWorkName,
        String extraWorkAddress,
        String extraWorkPosition,
        String extraWorkPhone,
        Integer extraWorkSalary,
        Integer extraWorkCurrencyId,
        LocalDate extraWorkStartDate,
        Integer extraWorkActivityTypeId) {
}
