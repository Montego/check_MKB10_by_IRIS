package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_SubjectsOfFederation")
public class SubjectsOfFederation {
    @Id
    private Integer subjectOfFederationId;
    private String name;

    //конструктор для информативного заполения JSON
    public SubjectsOfFederation(Boolean defaultValues){
        if (defaultValues){
            this.setSubjectOfFederationId(-1);
            this.setName("");
        }
    }
}
