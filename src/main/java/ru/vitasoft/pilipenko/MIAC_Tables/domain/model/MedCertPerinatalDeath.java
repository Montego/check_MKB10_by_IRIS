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

    @ManyToOne
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;              //FK

    @ManyToOne
    @JoinColumn(name = "DeathResultedWhen")
    private DeathResultedWhen deathResultedWhen;      //enum

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime deadFetus;                //date time?

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime childWasAlive;            //date time?

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime childDied;                //date time?

    private Integer civilRegistryOfficeWorker;      //
    private String bodyNumber;                      //
    private Integer deathChildNumber;               //
    private String lastName;                        //
    private String firstName;                       //
    private String patronymicName;                  //

    private Integer deathOccuredIn;                 //enum

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
    private ActRecord actRecordId;                  //FK

    @ManyToOne
    @JoinColumn(name = "PersonTookBirthId")
    private PersonTookBirth personTookBirthId;      //FK

    @ManyToOne
    @JoinColumn(name = "medOrgId")
    private MedOrg medOrgId;                        //FK

    private String motherLastName;                  //
    private String motherFirstName;                 //
    private String motherPatronymicName;            //

    private Integer motherFirstAppearanceToDoctor;  //
    private Integer motherChildNumber;              //

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
    private Occupation motherOccupationId;             //FK

    private Integer motherBirthYear;                //
    private Boolean motherBirthDateNone = false;    //
    private Integer motherBirthCount;               //

}
