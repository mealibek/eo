package kg.bakai.eo.models;

import jakarta.persistence.*;
import kg.bakai.eo.dto.BusinessInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "business_infos")
public class BusinessInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_info_id_seq")
    @SequenceGenerator(name = "business_info_id_seq", sequenceName = "business_info_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "person_activity_type_id")
    private Integer personActivityTypeId;

    @Column(name = "is_individual_entrepreneur")
    private Byte isIndividualEntrepreneur;

    @Column(name = "is_private_entrepreneur")
    private Byte isPrivateEntrepreneur;

    @Column(name = "okpo")
    private Integer OKPO;

    @Column(name = "legal_form_id")
    private Integer legalFormId;

    @Column(name = "activity_type_id")
    private Integer activityTypeId;

    @Column(name = "ownership_type_id")
    private Integer ownershipTypeId;

    @Column(name = "tax_office_id")
    private Integer taxOfficeId;

    @Column(name = "social_registration_no")
    private Integer socialRegistrationNo;

    @Column(name = "registration_authority")
    private Integer registrationAuthority;

    @Column(name = "date_of_registration")
    private LocalDate dateOfRegistration;

    public BusinessInfo(BusinessInfoDto dto) {
        this.personActivityTypeId = dto.personActivityTypeId();
        this.isIndividualEntrepreneur = dto.isIndividualEntrepreneur();
        this.isPrivateEntrepreneur = dto.isPrivateEntrepreneur();
        this.OKPO = dto.OKPO();
        this.legalFormId = dto.legalFormId();
        this.activityTypeId = dto.activityTypeId();
        this.ownershipTypeId = dto.ownershipTypeId();
        this.taxOfficeId = dto.taxOfficeId();
        this.socialRegistrationNo = dto.socialRegistrationNo();
        this.registrationAuthority = dto.registrationAuthority();
        this.dateOfRegistration = dto.dateOfRegistration();
    }
}
