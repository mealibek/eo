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
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    @Column(name = "customer_id")
    private Long customerID;

    @Column(name = "customer_type_id")
    private Integer customerTypeId;

    private String surname;

    @Column(name = "customer_name")
    private String customerName;

    private String otchestvo;

    private Byte sex;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "nationality_id")
    private Integer nationalityId;

    private Boolean resident;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "birth_country_id")
    private Integer birthCountryId;

    @Column(name = "birth_city_name")
    private String birthCityName;

    @Column(name = "birth_country_name")
    private String birthCountryName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_address_id", referencedColumnName = "id")
    private AddressInfo registrationAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "residence_address_id", referencedColumnName = "id")
    private AddressInfo residenceAddress;
}
