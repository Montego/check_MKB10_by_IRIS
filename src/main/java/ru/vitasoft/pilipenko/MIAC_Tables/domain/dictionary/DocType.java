package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

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
@Table(name = "D_DocType")
public class DocType {

    @Id
    private Integer docTypeId;
    private String name;

    //конструктор для информативного заполения JSON
    public DocType(Boolean defaultValues){
        if (defaultValues){

            this.setDocTypeId(-1);
            this.setName("");

        }
    }
}

