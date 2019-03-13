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
@Table(name = "D_FamilyStatus")
public class FamilyStatus {
    @Id
    private Integer familyStatusId;
    private String name;

    //конструктор для информативного заполения JSON
    public FamilyStatus(Boolean defaultValues){
        if (defaultValues){

            this.setFamilyStatusId(-1);
            this.setName("");

        }
    }
}

