package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.RelationshipToChild;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Recipient")
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipientId;
    private String lastName;
    private String firstName;
    private String patronymicName;
    private String documentSeries;
    private String documentNumber;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime documentIssueDate;

    private String issuedBy;

    @ManyToOne
    @JoinColumn(name = "RelationshipToChild")
    private RelationshipToChild relationshipToChild;    //enum

    @ManyToOne
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
            this.setDocumentIssueDate(LocalDateTime.parse("0001-01-01T00:00:00"));
            this.setIssuedBy("");
            this.setRelationshipToChild(new RelationshipToChild(true));    //enum
            this.setDocTypeId(new DocType(true));                          //dict
        }
    }
}


