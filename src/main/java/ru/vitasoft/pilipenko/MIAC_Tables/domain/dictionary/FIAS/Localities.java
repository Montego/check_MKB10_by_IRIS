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
@Table(name = "D_Localities")
public class Localities {
    @Id
    private Integer localityId;
    private String name;

    //конструктор для информативного заполения JSON
    public Localities(Boolean defaultValues){
        if (defaultValues){
            this.setLocalityId(-1);
            this.setName("");
        }
    }
}
