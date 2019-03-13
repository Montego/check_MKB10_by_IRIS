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
    private Integer medCertId;

    private Integer certSeries;
    private Integer certNumber;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime certIssueDate;

    private String certIssueByEmpl;
    private String certStatus;

    @ManyToOne
    @JoinColumn(name = "certType")
    private CertType certType;                  //enum

    private Boolean isDuplicate;
    private String privatePractitionerLicenceNumber;
    private String privatePractitionerAddress;
    private String filledOutMedCert;            //boolean?
    private String headOfMedOrg;

    @OneToOne
    @JoinColumn(name = "RecipientId")
    private Recipient recipientId;              //FK

    @OneToOne
    @JoinColumn(name = "PrevCertId")
    private MedCert prevCertId;                 //FK //!ссылка на самого себя

    //конструктор для информативного заполения JSON
    public MedCert(Boolean defaultValues){
        if (defaultValues){
            this.setMedCertId(-1);
            this.setCertSeries(-1);
            this.setCertNumber(-1);
            this.setCertIssueDate(LocalDateTime.parse("0001-01-01T00:00:00"));
            this.setCertIssueByEmpl("");
            this.setCertStatus("");
            this.setCertType(new CertType(true));
            this.setIsDuplicate(false);
            this.setPrivatePractitionerLicenceNumber("");
            this.setPrivatePractitionerAddress("");
            this.setFilledOutMedCert("");
            this.setHeadOfMedOrg("");
            this.setRecipientId(new Recipient(true));
            this.setPrevCertId(null);
        }
    }
}
