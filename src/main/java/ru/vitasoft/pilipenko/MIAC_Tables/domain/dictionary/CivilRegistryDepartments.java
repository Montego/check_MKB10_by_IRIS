package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_CivilRegistryDepartments")
public class CivilRegistryDepartments {

    @Positive
    @Id
    private Integer departmentId;

    @NotNull
    @Positive
    private Integer departmentCode;

    //конструктор для информативного заполения JSON
    public CivilRegistryDepartments(Boolean defaultValues){
        if (defaultValues){
            this.setDepartmentId(-1);
            this.setDepartmentCode(-1);
        }
    }


}

