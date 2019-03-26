package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

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
@Table(name = "deathReason")
public class DeathReason {
    @PositiveOrZero
    @Id
    private Integer deathReasonId;

    @NotNull
    @Size(max = 50)
    private String refType;

    private Integer refId; //TODO возможно нужно указать NotNull
}
