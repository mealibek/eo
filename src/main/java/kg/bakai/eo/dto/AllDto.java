package kg.bakai.eo.dto;

public record AllDto(
                CustomerDto customer,
                BusinessAddressInfoDto businessAddressInfo,
                BusinessInfoDto businessInfo,
                ContactInformationDto contactInformation,
                DocumentInfoDto documentInfo,
                FinancialInfoDto financialInfo,
                PersonalInfoDto personalInfo,
                WorkInformationDto workInformation) {
}
