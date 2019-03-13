package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Mkb10")
public class MKB10 {
    @Id
    private String mkbId;                   //STRING!
    private String name;

    //конструктор для информативного заполения JSON
    public MKB10(Boolean defaultValues){
        if (defaultValues){

            this.setMkbId("");
            this.setName("");

        }
    }
}
