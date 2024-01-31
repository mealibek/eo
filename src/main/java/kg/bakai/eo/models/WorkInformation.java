package kg.bakai.eo.models;

import jakarta.persistence.*;
import kg.bakai.eo.dto.WorkInformationDto;
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
    private boolean hasExtraWork;

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

    public WorkInformation(WorkInformationDto workInformationDto) {
        this.customer = workInformationDto.customerId();
        this.workName = workInformationDto.workName();
        this.workPosition = workInformationDto.workPosition();
        this.workPhone = workInformationDto.workPhone();
        this.employeesCount = workInformationDto.employeesCount();
        this.workSalary = workInformationDto.workSalary();
        this.workCurrencyId = workInformationDto.workCurrencyId();
        this.workAddress = workInformationDto.workAddress();
        this.workStartDate = workInformationDto.workStartDate();
        this.workTotalStartDate = workInformationDto.workTotalStartDate();
        this.hasExtraWork = workInformationDto.hasExtraWork();
        this.extraWorkName = workInformationDto.extraWorkName();
        this.extraWorkAddress = workInformationDto.extraWorkAddress();
        this.extraWorkPosition = workInformationDto.extraWorkPosition();
        this.extraWorkPhone = workInformationDto.extraWorkPhone();
        this.extraWorkSalary = workInformationDto.extraWorkSalary();
        this.extraWorkCurrencyId = workInformationDto.extraWorkCurrencyId();
        this.extraWorkStartDate = workInformationDto.extraWorkStartDate();
        this.extraWorkActivityTypeId = workInformationDto.extraWorkActivityTypeId();
    }
}
