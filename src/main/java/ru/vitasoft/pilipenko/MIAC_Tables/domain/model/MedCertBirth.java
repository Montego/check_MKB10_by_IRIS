package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertBirth.AccoucheurTypeB;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900DateOnly;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medCert_b")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertBirth {

    @Positive
    @Id
    @Column(name = "medCertBirthId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;                                 //

    @NotNull
    @OneToOne(fetch = FetchType.EAGER,optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                          //mod

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childBirthDateTime;           //Дата и время

    @Size(max = 100)
    private String lastName;                            //
    @Size(max = 100)
    private String firstName;                           //
    @Size(max = 100)
    private String patronymicName;                      //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "birthLocation")
    private BirthLocation birthLocation;                //enum

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
    private Integer childBornNumber;                    //

    @Positive
    private Integer totalChildBornNumber;               //

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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MotherFamilyStatus")
    private FamilyStatus motherFamilyStatus;          //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motherEduLevel")
    private EduLevel motherEduLevel;                    //enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motherEmplState")
    private EmplState motherEmplState;                  //enum

    @PositiveOrZero
    private Integer firstAppearanceToDoctor;            //

    @Positive
    private Integer childNumber;                        //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accoucheurType")
    private AccoucheurTypeB accoucheurTypeB;              //enum

    @Positive
    private Integer certIssueByEmpl;                    //

    //конструктор для информативного заполения JSON
    public MedCertBirth(Boolean defaultValues) {
        if (defaultValues) {
            this.setId(-1);                                 //
            this.setMedCertId(new MedCert(true));                          //mod
            this.setChildBirthDateTime(LocalDateTime.parse("0001-01-01T00:00:00"));           //Дата и время
            this.setLastName("");                            //
            this.setFirstName("");                           //
            this.setPatronymicName("");                      //
            this.setBirthLocation(null);                    //enum
            this.setGender(null);                           //enum
            this.setWeight(-1);                             //
            this.setLength(-1);                             //
            this.setFertility(null);                        //enum
            this.setChildBornNumber(-1);                    //
            this.setTotalChildBornNumber(-1);               //
            this.setMotherLastName("");                      //
            this.setMotherFirstName("");                     //
            this.setMotherPatronymicName("");                //
            this.setMotherBirthDate(LocalDate.parse("0001-01-01"));                  //Дата
            this.setMotherBirthDate_isYear(false);             //
            this.setMotherFamilyStatus(null);               //enum
            this.setMotherEduLevel(null);                   //enum
            this.setMotherEmplState(null);                  //enum
            this.setFirstAppearanceToDoctor(-1);            //
            this.setChildNumber(-1);                        //
            this.setAccoucheurTypeB(null);                  //enum
            this.setCertIssueByEmpl(-1);
        }
    }
}
