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
@Table(name = "work_infos")
public class WorkInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_info_id_seq")
    @SequenceGenerator(name = "work_info_id_seq", sequenceName = "work_info_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "work_name")
    private String workName;

    @Column(name = "work_position")
    private String workPosition;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "employees_count")
    private Integer employeesCount;

    @Column(name = "work_salary")
    private Integer workSalary;

    @Column(name = "work_currency_id")
    private Integer workCurrencyId;

    @Column(name = "work_address")
    private Integer workAddress;

    @Column(name = "work_start_date")
    private LocalDate workStartDate;

    @Column(name = "work_total_start_date")
    private LocalDate workTotalStartDate;

    @Column(name = "has_extra_work")
    private Byte hasExtraWork;

    @Column(name = "extra_work_name")
    private String extraWorkName;

    @Column(name = "extra_work_address")
    private String extraWorkAddress;

    @Column(name = "extra_work_position")
    private String extraWorkPosition;

    @Column(name = "extra_work_phone")
    private String extraWorkPhone;

    @Column(name = "extra_work_salary")
    private Integer extraWorkSalary;

    @Column(name = "extra_work_currency_id")
    private Integer extraWorkCurrencyId;

    @Column(name = "extra_work_start_date")
    private LocalDate extraWorkStartDate;

    @Column(name = "extra_work_activity_type_id")
    private Integer extraWorkActivityTypeId;
}
