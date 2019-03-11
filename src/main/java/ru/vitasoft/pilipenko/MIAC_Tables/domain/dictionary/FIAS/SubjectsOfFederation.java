package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table(name = "D_SubjectsOfFederation")
public class SubjectsOfFederation {
    @Id
    private Integer subjectOfFederationId;
    private String name;
}
