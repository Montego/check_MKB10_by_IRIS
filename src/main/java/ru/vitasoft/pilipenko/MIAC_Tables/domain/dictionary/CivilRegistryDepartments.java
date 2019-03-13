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
@Table(name = "D_CivilRegistryDepartments")
public class CivilRegistryDepartments {

    @Id
    private Integer departmentId;
    private Integer departmentCode;

    //конструктор для информативного заполения JSON
    public CivilRegistryDepartments(Boolean defaultValues){
        if (defaultValues){
            this.setDepartmentId(-1);
            this.setDepartmentCode(-1);
        }
    }


}

