package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertBirth.AccoucheurType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.DeathAccident;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.DeathLocation;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.RecordedDeathBased;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.RecordedDeathEmplType;
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
    @OneToOne(fetch = FetchType.EAGER)
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
    private DeathLocation deathLocation;                //enum

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
    private DeathAccident deathAccident;                            //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accoucheurType")
    private AccoucheurType accoucheurType;                          //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathEmplType")
    private RecordedDeathEmplType recordedDeathEmplType;            //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordedDeathEmplType")
    private RecordedDeathBased recordedDeathBased;                  //enum

    //конструктор для информативного заполения JSON
    public MedCertPerinatalDeath(Boolean defaultValues) {
        if (defaultValues){
            this.setId(-1);                                                         //
            this.setMedCertId(new MedCert(true));                      //FK

        }
    }
}
