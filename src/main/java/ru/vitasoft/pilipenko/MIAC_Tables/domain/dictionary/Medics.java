package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Medics")
public class Medics {

    @Id
    private Integer medicId;
    private String name;

    //конструктор для информативного заполения JSON
    public Medics(Boolean defaultValues){
        if (defaultValues){

            this.setMedicId(-1);
            this.setName("");

        }
    }
}
