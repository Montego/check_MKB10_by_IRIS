package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.AccoucheurTypeP;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900DateOnly;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//TODO в этом классе и связанных для всех ссылочных объектов было добавлено каскадирование, убрать его после проверки

@Entity
@Cacheable(value = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medCert_p")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertPerinatalDeath {

    @Positive
    @Id
    @Column(name = "medCertPerinatalDeathId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                                     //

    @NotNull
    @OneToOne(fetch = FetchType.EAGER,optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                              //FK

    @Size(max = 50)
    private String bodyNumber;                              //

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime deadFetusDateTime;                        //date time

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childBirthDateTime;                    //date time

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childDeathDateTime;                        //date time?

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "birthRelatedDeathMoment")
    private BirthRelatedDeathMoment birthRelatedDeathMoment;                                //enum

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

    private boolean motherBirthDate_isYear;             //
    private boolean motherBirthDate_isYearMonth;        //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motherFamilyStatus")
    private FamilyStatus motherFamilyStatus;          //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motherEduLevel")
    private EduLevel motherEduLevel;                    //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motherEmplState")
    private EmplState motherEmplState;                  //enum

    @PositiveOrZero
    private Integer motherBirthCount;            //

    @Size(max = 100)
    private String lastName;                            //
    @Size(max = 100)
    private String firstName;                           //
    @Size(max = 100)
    private String patronymicName;                      //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deathLocation")
    private DeathLocationP deathLocationP;                //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender")
    private Gender gender;                              //enum

    @Positive
    private Integer weight;                             //
    @Positive
    private Integer length;                             //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fertility")
    private Fertility fertility;                        //enum

    @Positive
    private Integer childBornNumber;                        //

    @Positive
    private Integer totalChildBornNumber;                        //

    @Positive
    private Integer deathChildNumber;                        //

    @Size(max = 100)
    private String actRecordEmployeeFirstName;                      //
    @Size(max = 100)
    private String actRecordEmployeeLastName;                       //
    @Size(max = 100)
    private String actRecordEmployeePatronymicName;                 //

    @Size(max = 100)
    private String actRecordNumber;                                 //

    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate actRecordDate;                                //Дата

    @Size(max = 100)
    private String registryDepartment;                              //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deathAccident")
    private DeathAccidentP deathAccidentP;                            //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accoucheurType")
    private AccoucheurTypeP accoucheurTypeP;                          //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathEmplType",insertable = false, updatable = false)
    private RecordedDeathEmplTypeP recordedDeathEmplTypeP;            //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathEmplType")
    private RecordedDeathBasedP recordedDeathBasedP;                  //enum

    //конструктор для информативного заполения JSON
    public MedCertPerinatalDeath(Boolean defaultValues) {
        if (defaultValues){
            this.setId(-1);                                                         //
            this.setMedCertId(new MedCert(true));                      //FK





//
//
//            private Integer id(-1);                                     //
//            private MedCert medCertId(new MedCert(true));                              //FK
//            private String bodyNumber("");                              //
//            private LocalDateTime deadFetusDateTime(LocalDateTime.parse("0001-01-01T00:00:00"));;                        //date time
//            private LocalDateTime childBirthDateTime(LocalDateTime.parse("0001-01-01T00:00:00"));;                    //date time
//            private LocalDateTime childDeathDateTime(LocalDateTime.parse("0001-01-01T00:00:00"));;                        //date time?
//            private BirthRelatedDeathMoment birthRelatedDeathMoment(null);                                //enum
//            private String motherLastName("");                      //
//            private String motherFirstName("");                     //
//            private String motherPatronymicName("");                //
//            private LocalDate motherBirthDate;                  //Дата
//            private boolean motherBirthDate_isYear(false);             //
//            private boolean motherBirthDate_isYearMonth(false);        //
//            private FamilyStatus motherFamilyStatus(null);          //enum
//            private EduLevel motherEduLevel(null);                    //enum
//            private EmplState motherEmplState(null);                  //enum
//            private Integer motherBirthCount(-1);            //
//            private String lastName("");                            //
//            private String firstName("");                           //
//            private String patronymicName("");                      //
//            private DeathLocationP deathLocationP(null);                //enum
//            private Gender gender(null);                              //enum
//            private Integer weight(-1);                             //
//            private Integer length(-1);                             //
//            private Fertility fertility(null);                        //enum
//            private Integer childBornNumber(-1);                        //
//            private Integer totalChildBornNumber(-1);                        //
//            private Integer deathChildNumber(-1);                        //
//            private String actRecordEmployeeFirstName("");                      //
//            private String actRecordEmployeeLastName("");                       //
//            private String actRecordEmployeePatronymicName("");                 //
//            private String actRecordNumber("");                                 //
//            private LocalDate actRecordDate;                                //Дата
//            private String registryDepartment("");                              //
//            private DeathAccidentP deathAccidentP(null);                            //enum
//            private AccoucheurTypeP accoucheurTypeP(null);                          //enum
//            private RecordedDeathEmplTypeP recordedDeathEmplTypeP(null);            //enum
//            private RecordedDeathBasedP recordedDeathBasedP(null);                  //enum


        }
    }
}
