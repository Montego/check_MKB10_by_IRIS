package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.RelationshipToChild;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900DateOnly;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

//TODO убрать каскадирование

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Recipient")
public class Recipient {

    @Positive
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipientId;
    @Size(max = 255)
    private String lastName;
    @Size(max = 255)
    private String firstName;
    @Size(max = 255)
    private String patronymicName;
    @Size(max = 255)
    private String documentSeries;
    @Size(max = 255)
    private String documentNumber;

    @PastOrPresent
    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate documentIssueDate;

    @Size(max = 255)
    private String issuedBy;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "RelationshipToChild")
    private RelationshipToChild relationshipToChild;    //enum

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "DocTypeId")
    private DocType docTypeId;                          //dict

    //конструктор для информативного заполения JSON
    public Recipient(Boolean defaultValues){
        if (defaultValues){
            this.setRecipientId(-1);
            this.setLastName("");
            this.setFirstName("");
            this.setPatronymicName("");
            this.setDocumentSeries("");
            this.setDocumentNumber("");
            this.setDocumentIssueDate(LocalDate.parse("0001-01-01"));
            this.setIssuedBy("");
            this.setRelationshipToChild(new RelationshipToChild(true));    //enum
            this.setDocTypeId(new DocType(true));                          //dict
        }
    }
}


