package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;
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
@Table(name = "MedCertPerinatalDeath")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertPerinatalDeath {

    @Positive
    @Id
    @Column(name = "MedCertPerinatalDeathId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                                     //

    @NotNull
    @OneToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                              //FK

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "DeathResultedWhen")
    private DeathResultedWhen deathResultedWhen;            //enum

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime deadFetus;                        //date time?

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childWasAlive;                    //date time?

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childDied;                        //date time?

    private Integer civilRegistryOfficeWorker;              //
    @Size(max = 255)
    private String bodyNumber;                              //
    private Integer deathChildNumber;                       //
    @Size(max = 255)
    private String lastName;                                //
    @Size(max = 255)
    private String firstName;                               //
    @Size(max = 255)
    private String patronymicName;                          //

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "DeathOccuredIn")
    private DeathOccuredIn deathOccuredIn;                  //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "Sex")
    private Sex sex;                                        //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "Fetus")
    private Fetus fetus;                                    //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "DeathOccuredFrom")
    private DeathOccuredFrom deathOccuredFrom;              //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "ReasonsEstablishedBy")
    private DeathReasonsEstablishedBy reasonsEstablishedBy; //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "ReasonsEstablishedOnBasisOf")
    private DeathReasonsEstablishedOnBasisOf reasonsEstablishedOnBasisOf;    //enum

    @PositiveOrZero
    private Integer weight;                         //
    @PositiveOrZero
    private Integer length;                         //

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "ActRecordId")
    private ActRecords actRecordId;                  //FK

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "PersonTookBirthId")
    private PersonTookBirth personTookBirthId;      //FK

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "medOrgId")
    private MedOrg medOrgId;                        //FK

    @Size(max = 255)
    private String motherLastName;                  //
    @Size(max = 255)
    private String motherFirstName;                 //
    @Size(max = 255)
    private String motherPatronymicName;            //

    @PositiveOrZero
    private Integer motherFirstAppearanceToDoctor;  //
    @Positive
    private Integer motherChildNumber;              //

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonSerialize()
    private LocalDateTime childBirthTimeDate;       //

    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate motherBirthDate;              //

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "MotherFamilyStatusId")
    private FamilyStatus motherFamilyStatusId;      //FK

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "MotherEduTypeId")
    private EduType motherEduTypeId;                //FK

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "MotherOccupationId")
    private Occupation motherOccupationId;          //FK

    @Positive
    @Min(1900)
    private Integer motherBirthYear;                //
    private Boolean motherBirthDateNone;            //
    @Positive
    private Integer motherBirthCount;               //

    //конструктор для информативного заполения JSON
    public MedCertPerinatalDeath(Boolean defaultValues) {
        if (defaultValues){
            this.setId(-1);                                                         //
            this.setMedCertId(new MedCert(true));                      //FK
            this.setDeathResultedWhen(new DeathResultedWhen(true));    //enum
            this.setDeadFetus(LocalDateTime.parse("0001-01-01T00:00:00"));          //date time?
            this.setChildWasAlive(LocalDateTime.parse("0001-01-01T00:00:00"));      //date time?
            this.setChildDied(LocalDateTime.parse("0001-01-01T00:00:00"));          //date time?
            this.setCivilRegistryOfficeWorker(-1);                                  //
            this.setBodyNumber("");                                                 //
            this.setDeathChildNumber(-1);                                           //
            this.setLastName("");                                                   //
            this.setFirstName("");                                                  //
            this.setPatronymicName("");                                             //
            this.setDeathOccuredIn(new DeathOccuredIn(true));           //enum
            this.setSex(new Sex(true));                                 //enum
            this.setFetus(new Fetus(true));                             //enum
            this.setDeathOccuredFrom(new DeathOccuredFrom(true));                               //enum
            this.setReasonsEstablishedBy(new DeathReasonsEstablishedBy(true));                  //enum
            this.setReasonsEstablishedOnBasisOf(new DeathReasonsEstablishedOnBasisOf(true));    //enum
            this.setWeight(-1);                                                     //
            this.setLength(-1);                                                     //
            this.setActRecordId(new ActRecords(true));                 //FK
            this.setPersonTookBirthId(new PersonTookBirth(true));      //FK
            this.setMedOrgId(new MedOrg(true));                        //FK
            this.setMotherLastName("");                                             //
            this.setMotherFirstName("");                                            //
            this.setMotherPatronymicName("");                                       //
            this.setMotherFirstAppearanceToDoctor(-1);                              //
            this.setMotherChildNumber(-1);                                          //
            this.setChildBirthTimeDate(LocalDateTime.parse("0001-01-01T00:00:00")); //
            this.setMotherBirthDate(LocalDate.parse("0001-01-01"));                 //
            this.setMotherFamilyStatusId(new FamilyStatus(true));      //FK
            this.setMotherEduTypeId(new EduType(true));                //FK
            this.setMotherOccupationId(new Occupation(true));          //FK
            this.setMotherBirthYear(-1);                                            //
            this.setMotherBirthDateNone(false);                                     //
            this.setMotherBirthCount(-1);                                           //
        }
    }
}
