package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.RelationshipToChild;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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

}


