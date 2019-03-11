package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "D_CivilRegistryDepartments")
public class CivilRegistryDepartments {

    @Id
    private Integer departmentId;
    private Integer departmentCode;

}

