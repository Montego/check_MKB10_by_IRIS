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
@Table(name = "D_EduType")
public class EduType {

    @Positive
    @Id
    private Integer eduTypeId;

    @NotNull
    @Size(min = 1)
    private String name;

    //конструктор для информативного заполения JSON
    public EduType(Boolean defaultValues){
        if (defaultValues){

            this.setEduTypeId(-1);
            this.setName("");

        }
    }
}


