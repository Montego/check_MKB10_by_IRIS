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
@Table(name = "D_EduType")
public class EduType {

    @Id
    private Integer eduTypeId;
    private String name;

    //конструктор для информативного заполения JSON
    public EduType(Boolean defaultValues){
        if (defaultValues){

            this.setEduTypeId(-1);
            this.setName("");

        }
    }
}


