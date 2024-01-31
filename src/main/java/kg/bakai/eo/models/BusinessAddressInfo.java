package kg.bakai.eo.models;

import jakarta.persistence.*;
import kg.bakai.eo.dto.BusinessAddressInfoDto;
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
@Table(name = "business_address_infos")
public class BusinessAddressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_address_info_id_seq")
    @SequenceGenerator(name = "business_address_info_id_seq", sequenceName = "business_address_info_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "business_city_id")
    private Integer businessCityId;

    @Column(name = "business_country_id")
    private Integer businessCountryId;

    @Column(name = "business_city_name")
    private String businessCityName;

    @Column(name = "business_street")
    private String businessStreet;

    @Column(name = "business_house")
    private String businessHouse;

    @Column(name = "business_flat")
    private String businessFlat;

    @Column(name = "business_postal_code")
    private String businessPostalCode;

    @Column(name = "start_business_date")
    private LocalDate startBusinessDate;

    @Column(name = "partners_count")
    private Integer partnersCount;

    public BusinessAddressInfo(BusinessAddressInfoDto dto) {
        this.businessCityId = dto.businessCityId();
        this.businessCountryId = dto.businessCountryId();
        this.businessCityName = dto.businessCityName();
        this.businessStreet = dto.businessStreet();
        this.businessHouse = dto.businessHouse();
        this.businessFlat = dto.businessFlat();
        this.businessPostalCode = dto.businessPostalCode();
        this.startBusinessDate = dto.startBusinessDate();
        this.partnersCount = dto.partnersCount();
    }
}
