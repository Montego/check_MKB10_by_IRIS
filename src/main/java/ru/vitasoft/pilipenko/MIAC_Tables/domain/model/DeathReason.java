package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deathReasonId;

    @NotNull
    @Size(max = 50)
    private String refType;
    private Integer refId; //TODO возможно нужно указать NotNull

    public DeathReason(Boolean defaultValues){
        if (defaultValues) {
            this.setDeathReasonId(null);
            this.setRefType("");
            this.setRefId(null);
        }
    }
}
