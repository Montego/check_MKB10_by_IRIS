package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MedCertBirth")
@JsonInclude(JsonInclude.Include.ALWAYS) //??? Требуется ли в данном случае Json?
public class MedCertBirth {
    @Id
    @Column(name = "medCertBirthId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToOne
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                       //mod

    private String lastName;
    private String firstName;
    private String patronymicName;

    @ManyToOne
    @JoinColumn(name = "ChildBirthOccured")
    private ChildBirthOccured childBirthOccured;    //enum

    @ManyToOne
    @JoinColumn(name = "Sex")
    private Sex sex;                                //enum

    @ManyToOne
    @JoinColumn(name = "WasBornFetus")
    private WasBornFetus wasBornFetus;              //enum

    private Integer weight;
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "personTookBirthId")
    private PersonTookBirth personTookBirthId;      //dict

    @ManyToOne
    @JoinColumn(name = "MedOrgId")
    private MedOrg medOrgId;                       //dict

    @ManyToOne
    @JoinColumn(name = "IssuedByMedicalAssistant")
    private IssuedByMedicalAssistant issuedByMedicalAssistant;       //enum

    private String motherLastName;
    private String motherFirstName;
    private String motherPatronymicName;
    private Integer firstAppearanceToDoctor;
    private Integer childNumber;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childBirthTimeDate;        //Дата и время

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime motherBirthDate;           //Дата

    @JsonProperty("motherBirthDateNone")
    private Boolean getMotherBirthDateNone(){return motherBirthDate == null;};

    private Integer motherBirthYear;

    @ManyToOne
    @JoinColumn(name = "MotherFamilyStatusId")
    private FamilyStatus motherFamilyStatusId;      //dict

    @ManyToOne
    @JoinColumn(name = "MotherEduTypeId")
    private EduType motherEduTypeId;                //dict

    @ManyToOne
    @JoinColumn(name = "motherOccupationId")
    private Occupation motherOccupationId;          //dict

    @ManyToOne
    @JoinColumn(name = "BirthType")
    private BirthType birthType;                    //enum

}

