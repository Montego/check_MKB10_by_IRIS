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
@Table(name = "D_Cities")
public class Cities {
    @Id
    private Integer cityId;
    private String name;

    //конструктор для информативного заполения JSON
    public Cities(Boolean defaultValues){
        if (defaultValues){
            this.setCityId(-1);
            this.setName("");
        }
    }
}
