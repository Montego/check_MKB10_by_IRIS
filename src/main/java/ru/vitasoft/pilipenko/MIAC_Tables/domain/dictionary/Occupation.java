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
@Table(name = "D_Occupation")
public class Occupation {
    @Id
    private Integer occupationId;
    private String name;

    //конструктор для информативного заполения JSON
    public Occupation(Boolean defaultValues){
        if (defaultValues){

            this.setOccupationId(-1);
            this.setName("");

        }
    }

}


