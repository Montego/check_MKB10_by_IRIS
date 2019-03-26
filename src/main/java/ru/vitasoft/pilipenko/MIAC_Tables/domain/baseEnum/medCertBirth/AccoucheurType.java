package ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertBirth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BE_accoucheurType_b")
public class AccoucheurType {
    @PositiveOrZero
    @Id
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String name;

}
