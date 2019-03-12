package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.CertType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Recipient;

import javax.persistence.*;
import java.security.Certificate;
import java.time.LocalDateTime;

@Entity
@Cacheable(value = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MedCertRepository")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medCertId = -1;

    private Integer certSeries = -1;
    private Integer certNumber = -1;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime certIssueDate = LocalDateTime.parse("0001-01-01T00:00:00");

    private String certIssueByEmpl = "";
    private String certStatus = "";

    @ManyToOne
    @JoinColumn(name = "certType")
    private CertType certType = new CertType();                   //enum

    private Boolean isDuplicate = false;
    private String privatePractitionerLicenceNumber = "";
    private String privatePractitionerAddress = "";
    private String filledOutMedCert = "";                          //boolean?
    private String headOfMedOrg = "";

    @OneToOne
    @JoinColumn(name = "RecipientId")
    private Recipient recipientId = new Recipient();              //FK

    @OneToOne
    @JoinColumn(name = "PrevCertId")
    private MedCert prevCertId;                 //FK //!ссылка на самого себя

}
