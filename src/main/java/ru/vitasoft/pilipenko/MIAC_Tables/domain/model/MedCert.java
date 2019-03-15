package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.CertType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Recipient;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900DateOnly;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TODO убрать каскадирование

@Entity
@Cacheable(value = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MedCertRepository")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCert {

    @Positive
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medCertId;

    @Positive
    private Integer certSeries;

    @Positive
    private Integer certNumber;

    @PastOrPresent
    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    //@JsonFormat(pattern = "dd.MM.yyyy'T'HH:mm:ss.SSS'Z'")
    private LocalDate certIssueDate;

    @Size(max = 255)
    private String certIssueByEmpl;
    @Size(max = 50)
    private String certStatus;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "certType")
    private CertType certType;                  //enum

    private Boolean isDuplicate;
    @Size(max = 255)
    private String privatePractitionerLicenceNumber;
    @Size(max = 255)
    private String privatePractitionerAddress;
    @Size(max = 255)
    private String filledOutMedCert;            //boolean?
    @Size(max = 255)
    private String headOfMedOrg;

    @NotNull
    @OneToOne(optional = false, cascade = CascadeType.ALL)
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
            this.setCertIssueDate(LocalDate.parse("0001-01-01"));
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
