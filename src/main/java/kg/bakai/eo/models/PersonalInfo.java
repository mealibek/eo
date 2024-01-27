package kg.bakai.eo.models;

import jakarta.persistence.*;
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
@Table(name = "personal_infos")
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_info_id_seq")
    @SequenceGenerator(name = "personal_info_id_seq", sequenceName = "personal_info_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "family_status_id")
    private Integer familyStatusId;

    @Column(name = "education_type_id")
    private Integer educationTypeId;

    @Column(name = "work_type_id")
    private Byte workTypeId;

    @Column(name = "business_address_remarks")
    private String businessAddressRemarks;

    @Column(name = "use_bank_client")
    private Byte useBankClient;

    @Column(name = "activity_note")
    private Integer activityNote;

    @Column(name = "first_registration_date")
    private LocalDate firstRegistrationDate;

    @Column(name = "evidence_registration_no")
    private Integer evidenceRegistrationNo;

    @Column(name = "is_political_person")
    private Byte isPoliticalPerson;

    @Column(name = "political_country_id")
    private Integer politicalCountryId;

    @Column(name = "political_position_id")
    private Integer politicalPositionId;
}
