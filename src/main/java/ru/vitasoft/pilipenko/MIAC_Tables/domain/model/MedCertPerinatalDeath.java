package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Cacheable(value = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MedCertPerinatalDeath")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertPerinatalDeath {

    @Id
    @Column(name = "MedCertPerinatalDeathId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//

    @OneToOne
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                      //FK

    @ManyToOne
    @JoinColumn(name = "DeathResultedWhen")
    private DeathResultedWhen deathResultedWhen;    //enum

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime deadFetus;                //date time?

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childWasAlive;            //date time?

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childDied;                //date time?

    private Integer civilRegistryOfficeWorker; //
    private String bodyNumber;                      //
    private Integer deathChildNumber;          //
    private String lastName;                        //
    private String firstName;                       //
    private String patronymicName;                  //

    private Integer deathOccuredIn;            //enum

    @ManyToOne
    @JoinColumn(name = "Sex")
    private Sex sex;                                //enum

    @ManyToOne
    @JoinColumn(name = "Fetus")
    private Fetus fetus;                            //enum

    @ManyToOne
    @JoinColumn(name = "DeathOccuredFrom")
    private DeathOccuredFrom deathOccuredFrom;      //enum

    @ManyToOne
    @JoinColumn(name = "ReasonsEstablishedBy")
    private DeathReasonsEstablishedBy reasonsEstablishedBy; //enum

    @ManyToOne
    @JoinColumn(name = "ReasonsEstablishedOnBasisOf")
    private DeathReasonsEstablishedOnBasisOf reasonsEstablishedOnBasisOf;    //enum

    private Integer weight;
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "ActRecordId")
    private ActRecords actRecordId;                  //FK

    @ManyToOne
    @JoinColumn(name = "PersonTookBirthId")
    private PersonTookBirth personTookBirthId;      //FK

    @ManyToOne
    @JoinColumn(name = "medOrgId")
    private MedOrg medOrgId;                        //FK

    private String motherLastName;             //
    private String motherFirstName;            //
    private String motherPatronymicName;       //

    private Integer motherFirstAppearanceToDoctor;  //
    private Integer motherChildNumber = -1;         //

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childBirthTimeDate;       //

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime motherBirthDate;          //

    @ManyToOne
    @JoinColumn(name = "MotherFamilyStatusId")
    private FamilyStatus motherFamilyStatusId;      //FK

    @ManyToOne
    @JoinColumn(name = "MotherEduTypeId")
    private EduType motherEduTypeId;                //FK

    @ManyToOne
    @JoinColumn(name = "MotherOccupationId")
    private Occupation motherOccupationId;          //FK

    private Integer motherBirthYear;           //
    private Boolean motherBirthDateNone;    //
    private Integer motherBirthCount;          //

    //конструктор для информативного заполения JSON
    public MedCertPerinatalDeath(Boolean defaultValues) {
        this.setId(-1);//
        this.setMedCertId(new MedCert(true));                      //FK
        this.setDeathResultedWhen(new DeathResultedWhen(true));    //enum
        this.setDeadFetus(LocalDateTime.parse("0001-01-01T00:00:00"));                //date time?
        this.setChildWasAlive(LocalDateTime.parse("0001-01-01T00:00:00"));            //date time?
        this.setChildDied(LocalDateTime.parse("0001-01-01T00:00:00"));                //date time?
        this.setCivilRegistryOfficeWorker(-1);       //
        this.setBodyNumber("");                      //
        this.setDeathChildNumber(-1);                //
        this.setLastName("");                        //
        this.setFirstName("");                       //
        this.setPatronymicName("");                  //
        this.setDeathOccuredIn(-1);                  //enum
        this.setSex(new Sex(true));                        //enum
        this.setFetus(new Fetus(true));                    //enum
        this.setDeathOccuredFrom(new DeathOccuredFrom(true));                               //enum
        this.setReasonsEstablishedBy(new DeathReasonsEstablishedBy(true));                  //enum
        this.setReasonsEstablishedOnBasisOf(new DeathReasonsEstablishedOnBasisOf(true));    //enum
        this.setWeight(-1);
        this.setLength(-1);
        this.setActRecordId(new ActRecords(true));                 //FK
        this.setPersonTookBirthId(new PersonTookBirth(true));      //FK
        this.setMedOrgId(new MedOrg(true));                        //FK
        this.setMotherLastName("");                     //
        this.setMotherFirstName("");                    //
        this.setMotherPatronymicName("");               //
        this.setMotherFirstAppearanceToDoctor(-1);      //
        this.setMotherChildNumber(-1);                  //
        this.setChildBirthTimeDate(LocalDateTime.parse("0001-01-01T00:00:00")); //
        this.setMotherBirthDate(LocalDateTime.parse("0001-01-01T00:00:00"));    //
        this.setMotherFamilyStatusId(new FamilyStatus(true));      //FK
        this.setMotherEduTypeId(new EduType(true));                //FK
        this.setMotherOccupationId(new Occupation(true));          //FK
        this.setMotherBirthYear(-1);           //
        this.setMotherBirthDateNone(false);    //
        this.setMotherBirthCount(-1);          //
    }
}
