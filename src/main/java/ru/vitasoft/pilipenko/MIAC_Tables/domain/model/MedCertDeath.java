package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathAccident;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathLocation;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.RecordedDeathEmplType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900;
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
@Table(name = "medCert_d")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertDeath {

    @Positive
    @Id
    @Column(name = "medCertDeathId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                      //FK

    @Size(max = 50)
    private String bodyNumber;

    @Size(max = 100)
    private String lastName;
    @Size(max = 100)
    private String firstName;
    @Size(max = 100)
    private String patronymicName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "identDocTypeId")
    private IdentityDoc identDocTypeId;                                //enum

    @Size(max = 50)
    private String identDocSeries;

    @Size(max = 50)
    private String identDocNumber;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime identDocIssueDate;

    @Size(max = 50)
    private String identDocIssueBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender")
    private Gender gender;                                //enum

    @NullOrAfter1900DateOnly
    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;

    private boolean birthDate_isYear;                       //

    private boolean birthDate_isYearMonth;                  //

    @NullOrAfter1900
    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime deathDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deathLocation")
    private DeathLocation deathLocation;                    //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fetusType")
    private FetusType fetusType;                            //enum

    @Size(max = 100)
    private String motherLastName;                      //
    @Size(max = 100)
    private String motherFirstName;                     //
    @Size(max = 100)
    private String motherPatronymicName;                //

    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate motherBirthDate;                  //Дата

    @Positive
    private Integer weight;                             //

    @Positive
    private Integer deathChildNumber;                    //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "familyStatus")
    private FamilyStatus familyStatus;                  //enum


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eduLevel")
    private EduLevel eduLevel;                    //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emplState")
    private EmplState emplState;                  //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deathAccident")
    private DeathAccident deathAccident;          //enum

    @NullOrAfter1900
    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime accidentDate;

    @Size(max = 255)
    private String accidentPlaceAndConditions;                      //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathEmplType")
    private RecordedDeathEmplType recordedDeathEmplType;            //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathBased")
    private RecordedDeathEmplType recordedDeathBased;               //enum

    @Positive
    private Integer medicId;                                        //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deathRoadAccidentState")
    private DeathRoadAccidentState deathRoadAccidentState;               //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deathPregnantState")
    private DeathPregnantState deathPregnantState;               //enum


    //конструктор для информативного заполения JSON
    public MedCertDeath(Boolean defaultValues) {
        if (defaultValues){
            this.setId(-1);//
            this.setMedCertId(new MedCert(true));                      //FK
            this.setBodyNumber("");
            this.setLastName("");
            this.setFirstName("");
            this.setPatronymicName("");//enum
            this.setBirthDate(LocalDate.parse("0001-01-01"));
            this.setDeathDate(LocalDateTime.parse("0001-01-01T00:00:00"));
        }
    }
}