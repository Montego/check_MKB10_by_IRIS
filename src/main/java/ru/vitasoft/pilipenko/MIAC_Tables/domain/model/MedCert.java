package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.CertType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.IdentityDoc;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Recepient;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900DateOnly;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Cacheable(value = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medCert")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCert {

    @Positive
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medCertId;

    @Size(max = 50)
    private String certSeries;

    @Size(max = 50)
    private String certNumber;

    @PastOrPresent
    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate certIssueDate;

    private Boolean isDuplicate;
    private Boolean isPrivatePracticioner;

    @Size(max = 50)
    private String privatePractitionerLicenceNumber;

    @Size(max = 50)
    private String privatePractitionerAddress; //TODO 50 мало для адреса

    @PositiveOrZero
    private Integer resolutionBy; //TODO ссылка?

    @Size(max = 50)
    private String resolution;

    @PositiveOrZero
    private Integer medOrgId; //TODO ссылка?

    @PositiveOrZero
    private Integer filledOutMedCertId;

    @PositiveOrZero
    private Integer headOfMedOrgId;

    @PositiveOrZero
    private Integer checkedBy;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime checkDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "certType")
    private CertType certType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "certStatus")
    private CertType certStatus;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prevCertId")
    private MedCert prevCertId;

    //конструктор для информативного заполения JSON
    public MedCert(Boolean defaultValues){
        if (defaultValues){
            this.setMedCertId(-1);
            this.setCertSeries("");
            this.setCertNumber("");
            this.setCertIssueDate(LocalDate.parse("0001-01-01"));
            this.setCertStatus(null);
            this.setCertType(null);
            this.setIsDuplicate(false);
            this.setPrivatePractitionerLicenceNumber("");
            this.setPrivatePractitionerAddress("");
            this.setPrevCertId(null);
        }
    }
}
