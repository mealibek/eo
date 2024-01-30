package kg.bakai.eo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "contact_infos")
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_info_id_seq")
    @SequenceGenerator(name = "contact_info_id_seq", sequenceName = "contact_info_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "contact_phone_1")
    private String contactPhone1;

    @Column(name = "contact_phone_2")
    private String contactPhone2;

    @Column(name = "contact_address")
    private String contactAddress;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_person_phone")
    private String contactPersonPhone;

    @Column(name = "email")
    private String email;
}
