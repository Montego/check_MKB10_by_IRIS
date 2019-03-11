package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "D_DeathReasonsDiag")
public class DeathReasonsDiag {
    @Id
    private Integer deathReasonDiagnId;

    @ManyToOne
    @JoinColumn(name = "DeathReasonId")
    private DeathReasons deathReasonId; //FK
    private Integer diagnType;
    private String description;
    private Integer years;
    private Integer months;
    private Integer days;
    private Integer hours;
    private Integer minutes;

    @ManyToOne
    @JoinColumn(name = "MkbId")
    private MKB10 mkbId;                //FK

}
