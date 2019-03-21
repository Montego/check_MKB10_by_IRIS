package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900DateOnly;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.YearBeforeThis;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//TODO в этом классе и связанных для всех ссылочных объектов было добавлено каскадирование, убрать его после проверки

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MedCertBirth")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertBirth {

    @Positive
    @Id
    @Column(name = "medCertBirthId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;                                 //

    @NotNull
    @OneToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                          //mod

    @Size(max = 255)
    private String lastName;                            //
    @Size(max = 255)
    private String firstName;                           //
    @Size(max = 255)
    private String patronymicName;                      //

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "ChildBirthOccured")
    private ChildBirthOccured childBirthOccured;        //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "Sex")
    private Sex sex;                                    //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "WasBornFetus")
    private WasBornFetus wasBornFetus;                  //enum

    @Positive
    private Integer weight;                             //
    @Positive
    private Integer length;                             //

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "personTookBirthId")
    private PersonTookBirth personTookBirthId;          //dict

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "MedOrgId")
    private MedOrg medOrgId;                            //dict

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "IssuedByMedicalAssistant")
    private IssuedByMedicalAssistant issuedByMedicalAssistant;       //enum
    @Size(max = 255)
    private String motherLastName;                      //
    @Size(max = 255)
    private String motherFirstName;                     //
    @Size(max = 255)
    private String motherPatronymicName;                //

    @PositiveOrZero
    private Integer firstAppearanceToDoctor;            //
    @Positive
    private Integer childNumber;                        //

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childBirthTimeDate;           //Дата и время

    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate motherBirthDate;                  //Дата

    @JsonProperty("motherBirthDateNone")
    private Boolean getMotherBirthDateNone;             //

    @Min(1900)
    @YearBeforeThis
    private Integer motherBirthYear;                    //

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "MotherFamilyStatusId")
    private FamilyStatus motherFamilyStatusId;          //dict

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "MotherEduTypeId")
    private EduType motherEduTypeId;                    //dict

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "motherOccupationId")
    private Occupation motherOccupationId;              //dict

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}) //def fetch = EAGER
    @JoinColumn(name = "BirthType")
    private BirthType birthType;                        //enum

    //конструктор для информативного заполения JSON
    public MedCertBirth(Boolean defaultValues) {
        if (defaultValues) {
            this.setId(-1);                                                         //
            this.setMedCertId(new MedCert(true));                       //mod
            this.setLastName("");                                                   //
            this.setFirstName("");                                                  //
            this.setPatronymicName("");                                             //
            this.setChildBirthOccured(new ChildBirthOccured(true));    //enum
            this.setSex(new Sex(true));                                //enum
            this.setWasBornFetus(new WasBornFetus(true));              //enum
            this.setWeight(-1);                                                     //
            this.setLength(-1);                                                     //
            this.setPersonTookBirthId(new PersonTookBirth(true));      //dict
            this.setMedOrgId(new MedOrg(true));                        //dict
            this.setIssuedByMedicalAssistant(new IssuedByMedicalAssistant(true));       //enum
            this.setMotherLastName("");                                             //
            this.setMotherFirstName("");                                            //
            this.setMotherPatronymicName("");                                       //
            this.setFirstAppearanceToDoctor(-1);                                    //
            this.setChildNumber(-1);                                                //
            this.setChildBirthTimeDate(LocalDateTime.parse("0001-01-01T00:00:00")); //Дата и время
            this.setMotherBirthDate(LocalDate.parse("0001-01-01"));                 //Дата
            this.setGetMotherBirthDateNone(false);                                  //
            this.setMotherBirthYear(-1);                                            //
            this.setMotherFamilyStatusId(new FamilyStatus(true));      //dict
            this.setMotherEduTypeId(new EduType(true));                //dict
            this.setMotherOccupationId(new Occupation(true));          //dict
            this.setBirthType(new BirthType(true));                    //enum
        }
    }
}
