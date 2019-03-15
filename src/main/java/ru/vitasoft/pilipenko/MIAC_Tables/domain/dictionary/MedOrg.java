package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_MedOrg")
public class MedOrg {

    @Positive
    @Id
    private Integer medOrgId;

    @Size(max = 255)
    private String name;

    //конструктор для информативного заполения JSON
    public MedOrg(Boolean defaultValues){
        if (defaultValues){

            this.setMedOrgId(-1);
            this.setName("");

        }
    }
}
