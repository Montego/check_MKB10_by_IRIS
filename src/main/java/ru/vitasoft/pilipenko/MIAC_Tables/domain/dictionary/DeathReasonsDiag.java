package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.DiagnType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_DeathReasonsDiag")
public class DeathReasonsDiag {

    @Positive
    @Id
    private Integer deathReasonDiagnId;

    @ManyToOne
    @JoinColumn(name = "DeathReasonId")
    private DeathReasons deathReasonId; //FK

    @ManyToOne
    @JoinColumn(name = "DiagnType")
    private DiagnType diagnType;

    @Size(max = 255)
    private String description;

    @Positive
    private Integer years;

    @Positive
    @Max(12)
    private Integer months;

    @Max(366)
    private Integer days;

    @Max(24)
    private Integer hours;

    @Max(60)
    private Integer minutes;

    @ManyToOne
    @JoinColumn(name = "MkbId")
    private MKB10 mkbId;                //FK


    //конструктор для информативного заполения JSON
    public DeathReasonsDiag(Boolean defaultValues){
        if (defaultValues){
            this.setDeathReasonDiagnId(-1);
            this.setDeathReasonId(new DeathReasons(true));
            this.setDiagnType(new DiagnType(true));
            this.setDescription("");
            this.setYears(-1);
            this.setMonths(-1);
            this.setDays(-1);
            this.setHours(-1);
            this.setMinutes(-1);
            this.setMkbId(new MKB10(true));
        }
    }
}
