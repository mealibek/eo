package kg.bakai.eo.models;

import jakarta.persistence.*;
import kg.bakai.eo.dto.FinancialInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "financial_infos")
public class FinancialInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_info_id_seq")
    @SequenceGenerator(name = "financial_info_id_seq", sequenceName = "financial_info_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "origin_of_funds_comment")
    private String originOfFundsComment;

    @Column(name = "origin_of_funds_type_id")
    private Integer originOfFundsTypeId;

    @Column(name = "use_online_statement")
    private Byte useOnlineStatement;

    @Column(name = "beneficiary_id")
    private Integer beneficiaryId;

    @Column(name = "is_financial_company")
    private Byte isFinancialCompany;

    @Column(name = "is_exchange_office")
    private Byte isExchangeOffice;

    @Column(name = "high_risk_reason_comment")
    private String highRiskReasonComment;

    @Column(name = "is_allow_sms_receive")
    private Byte isAllowSmsReceive;

    @Column(name = "is_allow_marketing_receive")
    private Byte isAllowMarketingReceive;

    @Column(name = "fatca_criteon")
    private Integer fatcaCriteon;

    @Column(name = "client_type")
    private Byte clientType;

    @Column(name = "customer_reason_avay_id")
    private Integer customerReasonAvayId;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "receive_language")
    private Byte receiveLanguage;

    @Column(name = "is_owner_residence")
    private Byte isOwnerResidence;

    @Column(name = "is_allow_to_cib_send")
    private Byte isAllowToCIBSend;

    @Column(name = "is_doc_unlimited")
    private Byte isDocUnlimited;

    @Column(name = "legal_document_id")
    private Byte legalDocumentId;

    public FinancialInfo(FinancialInfoDto dto) {
        this.originOfFundsComment = dto.originOfFundsComment();
        this.originOfFundsTypeId = dto.originOfFundsTypeId();
        this.useOnlineStatement = dto.useOnlineStatement();
        this.beneficiaryId = dto.beneficiaryId();
        this.isFinancialCompany = dto.isFinancialCompany();
        this.isExchangeOffice = dto.isExchangeOffice();
        this.highRiskReasonComment = dto.highRiskReasonComment();
        this.isAllowSmsReceive = dto.isAllowSmsReceive();
        this.isAllowMarketingReceive = dto.isAllowMarketingReceive();
        this.fatcaCriteon = dto.fatcaCriteon();
        this.clientType = dto.clientType();
        this.customerReasonAvayId = dto.customerReasonAvayId();
        this.codeName = dto.codeName();
        this.receiveLanguage = dto.receiveLanguage();
        this.isOwnerResidence = dto.isOwnerResidence();
        this.isAllowToCIBSend = dto.isAllowToCIBSend();
        this.isDocUnlimited = dto.isDocUnlimited();
        this.legalDocumentId = dto.legalDocumentId();
    }
}
