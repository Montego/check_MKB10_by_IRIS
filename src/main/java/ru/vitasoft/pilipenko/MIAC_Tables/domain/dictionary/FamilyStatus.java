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
@Table(name = "D_FamilyStatus")
public class FamilyStatus {

    @Positive
    @Id
    private Integer familyStatusId;

    @NotNull
    @Size(min = 1)
    private String name;

    //конструктор для информативного заполения JSON
    public FamilyStatus(Boolean defaultValues){
        if (defaultValues){

            this.setFamilyStatusId(-1);
            this.setName("");

        }
    }
}

