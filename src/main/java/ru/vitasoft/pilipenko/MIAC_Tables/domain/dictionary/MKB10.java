package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Mkb10")
public class MKB10 {

    @Positive
    @Id
    private String mkbId; //STRING!

    @NotNull
    @Size(min = 1,max = 255)
    private String name;

    //конструктор для информативного заполения JSON
    public MKB10(Boolean defaultValues){
        if (defaultValues){

            this.setMkbId("");
            this.setName("");

        }
    }
}
