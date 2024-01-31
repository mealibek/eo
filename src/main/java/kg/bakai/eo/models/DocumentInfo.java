package kg.bakai.eo.models;

import jakarta.persistence.*;
import kg.bakai.eo.dto.DocumentInfoDto;
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
@Table(name = "document_infos")
public class DocumentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_info_id_seq")
    @SequenceGenerator(name = "document_info_id_seq", sequenceName = "document_info_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "document_type_id")
    private Integer documentTypeId;

    @Column(name = "document_series")
    private String documentSeries;

    @Column(name = "document_no")
    private String documentNo;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "issue_authority")
    private String issueAuthority;

    @Column(name = "document_valid_till")
    private LocalDate documentValidTill;

    public DocumentInfo(DocumentInfoDto dto) {
        this.documentTypeId = dto.documentTypeId();
        this.documentSeries = dto.documentSeries();
        this.documentNo = dto.documentNo();
        this.issueDate = dto.issueDate();
        this.issueAuthority = dto.issueAuthority();
        this.documentValidTill = dto.documentValidTill();
    }
}
