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
    private Integer id = -1;//

    @OneToOne
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                      //FK

    private String bodyNumber = "";

    private String lastName = "";
    private String firstName = "";
    private String patronymicName = "";

    @ManyToOne
    @JoinColumn(name = "Sex")
    private Sex sex;                                //enum

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime birthDate = LocalDateTime.parse("0001-01-01T00:00:00");

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime deathDate = LocalDateTime.parse("0001-01-01T00:00:00");

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

    private Integer birthYear = -1;

    private Boolean birthDateNone = false;
    private Boolean birthDateUnknown = false;

    //конструктор для информативного заполения JSON
    public MedCertDeath(Boolean defaultValues) {
        this.setId(-1);//
        this.setMedCertId(new MedCert(true));                      //FK
        this.setBodyNumber("");
        this.setLastName("");
        this.setFirstName("");
        this.setPatronymicName("");
        this.setSex(new Sex(true));                                //enum
        this.setBirthDate(LocalDateTime.parse("0001-01-01T00:00:00"));
        this.setDeathDate(LocalDateTime.parse("0001-01-01T00:00:00"));
        this.setDeathResultedFrom(new DeathReasons(true));         //enum ???
        this.setDeathOccuredIn(new DeathOccuredIn(true));          //enum
        this.setDeathReasonsEstablishedBy(new DeathReasonsEstablishedBy(true));      //enum
        this.setReasonsForDeathEstablishing(new ReasonsForDeathEstablishing(true));    //enum
        this.setFamilyStatusId(new FamilyStatus(true));           //FK
        this.setEduTypeId(new EduType(true));                     //FK
        this.setMedicId(new Medics(true));                        //FK
        this.setOccupationId(new Occupation(true));               //FK
        this.setMedOrgId(new MedOrg(true));                       //FK
        this.setBirthYear(-1);
        this.setBirthDateNone(false);
        this.setBirthDateUnknown(false);
    }
}