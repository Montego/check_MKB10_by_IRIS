package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Occupation")
public class Occupation {

    @Positive
    @Id
    private Integer occupationId;

    @NotNull
    @Size(min = 1,max = 255)
    private String name;

    //конструктор для информативного заполения JSON
    public Occupation(Boolean defaultValues){
        if (defaultValues){

            this.setOccupationId(-1);
            this.setName("");

        }
    }

}


