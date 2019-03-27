package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathAccidentD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathLocationD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.RecordedDeathBasedD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.RecordedDeathEmplTypeD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.IdentityDoc;
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

    @PositiveOrZero
    @Id
    @Column(name = "medCertDeathId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//

    @NotNull
    @OneToOne(fetch = FetchType.EAGER,optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
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
    private LocalDate identDocIssueDate;

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
    private DeathLocationD deathLocationD;                    //enum

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
    private DeathAccidentD deathAccidentD;          //enum

    @NullOrAfter1900
    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime accidentDate;

    @Size(max = 255)
    private String accidentPlaceAndConditions;                      //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathEmplType")
    private RecordedDeathEmplTypeD recordedDeathEmplTypeD;            //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathBased")
    private RecordedDeathBasedD recordedDeathBasedD;               //enum

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
            this.setPatronymicName("");
            this.setIdentDocTypeId(null);                                //enum
            this.setIdentDocSeries("");
            this.setIdentDocNumber("");
            this.setIdentDocIssueDate(LocalDate.parse("0001-01-01"));;

            this.setIdentDocIssueBy("");
            this.setGender(null);                                //enum
            this.setBirthDate(LocalDate.parse("0001-01-01"));
            this.setBirthDate_isYear(false);                       //
            this.setBirthDate_isYearMonth(false);                  //
            this.setDeathDate(LocalDateTime.parse("0001-01-01T00:00:00"));
            this.setDeathLocationD(null);                    //enum
            this.setFetusType(null);                            //enum
            this.setMotherLastName("");                      //
            this.setMotherFirstName("");                     //
            this.setMotherPatronymicName("");                //
            this.setMotherBirthDate(LocalDate.parse("0001-01-01"));                  //Дата
            this.setWeight(-1);                             //
            this.setDeathChildNumber(-1);                    //
            this.setFamilyStatus(null);                  //enum
            this.setEduLevel(null);                    //enum
            this.setEmplState(null);                  //enum
            this.setDeathAccidentD(null);          //enum
            this.setAccidentDate(LocalDateTime.parse("0001-01-01T00:00:00"));
            this.setAccidentPlaceAndConditions("");                      //
            this.setRecordedDeathEmplTypeD(null);            //enum
            this.setRecordedDeathBasedD(null);               //enum
            this.setMedicId(-1);                                        //
            this.setDeathRoadAccidentState(null);               //enum
            this.setDeathPregnantState(null);               //enum


        }
    }
}