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
@Table(name = "address_infos")
public class AddressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_info_id_seq")
    @SequenceGenerator(name = "address_info_seq", sequenceName = "address_info_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "city_name")
    private String cityName;

    private String street;
    private String house;
    private String flat;
}
