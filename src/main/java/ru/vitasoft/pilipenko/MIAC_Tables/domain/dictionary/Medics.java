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
@Table(name = "D_Medics")
public class Medics {

    @Positive
    @Id
    private Integer medicId;

    @NotNull
    @Size(min = 1)
    private String name;

    //конструктор для информативного заполения JSON
    public Medics(Boolean defaultValues){
        if (defaultValues){

            this.setMedicId(-1);
            this.setName("");

        }
    }
}
