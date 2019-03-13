package ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum;

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
@Table(name = "BE_ReasonsForDeathEstablishing")
public class ReasonsForDeathEstablishing {
    @Id
    private Integer id;
    private String name;

    //конструктор для информативного заполения JSON
    public ReasonsForDeathEstablishing(Boolean defaultValues){
        if (defaultValues){
            this.setId(-1);
            this.setName("");
        }
    }
}

