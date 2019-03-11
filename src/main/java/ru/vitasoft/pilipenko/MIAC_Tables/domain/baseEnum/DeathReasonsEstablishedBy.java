package ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "BE_ReasonsEstablishedBy")
public class DeathReasonsEstablishedBy {
    @Id
    private Integer id;
    private String name;
}

