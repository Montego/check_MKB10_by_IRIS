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
@Table(name = "D_Countries")
public class Countries {
    @Id
    private Integer countryId;
    private String name;

    //конструктор для информативного заполения JSON
    public Countries(Boolean defaultValues){
        if (defaultValues){
            this.setCountryId(-1);
            this.setName("");
        }
    }
}
