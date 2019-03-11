package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.DeathOccuredIn;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.DeathReasonsEstablishedBy;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.ReasonsForDeathEstablishing;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.Sex;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Cacheable(value = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MedCertDeath")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertDeath {
    @Id
    @Column(name = "medCertDeathId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//

    @ManyToOne
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                      //FK

    private String bodyNumber;

    private String lastName;
    private String firstName;
    private String patronymicName;

    @ManyToOne
    @JoinColumn(name = "Sex")
    private Sex sex;                                //enum

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime birthDate;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime deathDate;

    @ManyToOne
    @JoinColumn(name = "DeathResultedFrom")
    private DeathReasons deathResultedFrom;         //enum ???

    @ManyToOne
    @JoinColumn(name = "DeathOccuredIn")
    private DeathOccuredIn deathOccuredIn;          //enum

    @ManyToOne
    @JoinColumn(name = "DeathReasonsEstablishedBy")
    private DeathReasonsEstablishedBy deathReasonsEstablishedBy;      //enum

    @ManyToOne
    @JoinColumn(name = "ReasonsForDeathEstablishing")
    private ReasonsForDeathEstablishing reasonsForDeathEstablishing;    //enum

    @ManyToOne
    @JoinColumn(name = "FamilyStatusId")
    private FamilyStatus familyStatusId;           //FK

    @ManyToOne
    @JoinColumn(name = "EduTypeId")
    private EduType eduTypeId;                     //FK

    @ManyToOne
    @JoinColumn(name = "MedicId")
    private Medics medicId;                        //FK

    @ManyToOne
    @JoinColumn(name = "OccupationId")
    private Occupation occupationId;               //FK

    @ManyToOne
    @JoinColumn(name = "MedOrgId")
    private MedOrg medOrgId;                       //FK

    private Integer birthYear;

    private Boolean birthDateNone       = false;
    private Boolean birthDateUnknown    = false;

}
