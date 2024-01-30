package kg.bakai.eo.dto;

public record AllDto(
        CustomerDto customerDto,
        AddressInfoDto addressInfoDto,
        BusinessAddressInfoDto businessAddressInfoDto,
        BusinessInfoDto businessInfoDto,
        ContactInformationDto contactInformationDto,
        DocumentInfoDto documentInfoDto,
        FinancialInfoDto financialInfoDto,
        PersonalInfoDto personalInfoDto,
        WorkInformationDto workInformationDto
) {
}
