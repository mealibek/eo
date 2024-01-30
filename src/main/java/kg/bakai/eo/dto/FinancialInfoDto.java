package kg.bakai.eo.dto;

public record FinancialInfoDto(
        Long id,
        Long customerId,
        String originOfFundsComment,
        Integer originOfFundsTypeId,
        Byte useOnlineStatement,
        Integer beneficiaryId,
        Byte isFinancialCompany,
        Byte isExchangeOffice,
        String highRiskReasonComment,
        Byte isAllowSmsReceive,
        Byte isAllowMarketingReceive,
        Integer fatcaCriteon,
        Byte clientType,
        Integer customerReasonAvayId,
        String codeName,
        Byte receiveLanguage,
        Byte isOwnerResidence,
        Byte isAllowToCIBSend,
        Byte isDocUnlimited,
        Byte legalDocumentId
) {
}
