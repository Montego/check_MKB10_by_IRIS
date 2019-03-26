package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.RelationshipType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.IdentityDoc;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "recepient")
public class Recepient {
    @PositiveOrZero
    @Id
    private Integer recepientId;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medCertId")
    private MedCert medCertId;

    @Size(max = 100)
    private String lastName;

    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String patronymicName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "identDocTypeId")
    private IdentityDoc identDocTypeId;

    @Size(max = 50)
    private String identDocSeries;

    @Size(max = 50)
    private String identDocNumber;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime identDocIssueDate;

    @Size(max = 50)
    private String identDocIssueBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relationshipType")
    private RelationshipType relationshipType;

}
