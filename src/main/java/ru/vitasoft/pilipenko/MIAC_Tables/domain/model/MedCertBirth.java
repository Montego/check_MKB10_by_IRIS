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
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertBirth.AccoucheurType;
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
@Table(name = "medCert_b")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MedCertBirth {

    @Positive
    @Id
    @Column(name = "medCertBirthId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;                                 //

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MedCertId")
    private MedCert medCertId;                          //mod

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime childBirthTimeDate;           //Дата и время

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
    private AccoucheurType accoucheurType;              //enum

    @Positive
    private Integer certIssueByEmpl;                    //


    //конструктор для информативного заполения JSON
    public MedCertBirth(Boolean defaultValues) {
        if (defaultValues) {
            this.setId(-1);                                                         //
            this.setMedCertId(new MedCert(true));                       //mod
            this.setLastName("");                                                   //
            this.setFirstName("");                                                  //
            this.setPatronymicName("");                                             //
            this.setWeight(-1);                                                     //
            this.setLength(-1);                                                     //
            this.setMotherLastName("");                                             //
            this.setMotherFirstName("");                                            //
            this.setMotherPatronymicName("");                                       //
            this.setFirstAppearanceToDoctor(-1);                                    //
            this.setChildNumber(-1);                                                //
            this.setChildBirthTimeDate(LocalDateTime.parse("0001-01-01T00:00:00")); //Дата и время
            this.setMotherBirthDate(LocalDate.parse("0001-01-01"));                 //Дата

        }
    }
}
