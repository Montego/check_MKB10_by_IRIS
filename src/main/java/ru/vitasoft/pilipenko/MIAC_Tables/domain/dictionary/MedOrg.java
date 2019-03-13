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
@Table(name = "D_MedOrg")
public class MedOrg {
    @Id
    private Integer medOrgId;
    private String name;

    //конструктор для информативного заполения JSON
    public MedOrg(Boolean defaultValues){
        if (defaultValues){

            this.setMedOrgId(-1);
            this.setName("");

        }
    }
}
