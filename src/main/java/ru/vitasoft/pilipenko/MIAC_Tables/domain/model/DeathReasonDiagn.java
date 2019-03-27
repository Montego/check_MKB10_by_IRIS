package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.DiagnType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.MKB10;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "deathReasonDiagn")
public class DeathReasonDiagn {
    @PositiveOrZero
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deathReasonDiagnId;

    @ManyToOne(fetch = FetchType.EAGER,optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "deathReasonId")
    private DeathReason deathReasonId;

    @ManyToOne
    @JoinColumn(name = "diagnType")
    private DiagnType diagnType;

    @Size(max = 200)
    private String description;

    @PositiveOrZero
    private Integer years;
    @PositiveOrZero
    private Integer months;
    @PositiveOrZero
    private Integer days;
    @PositiveOrZero
    private Integer hours;
    @PositiveOrZero
    private Integer minutes;
    @PositiveOrZero
    private Integer timeUnknown; //TODO проверить поле

    @ManyToOne
    @JoinColumn(name = "mkbId")
    private MKB10 mkbId;

    //конструктор для информативного заполения JSON
    public DeathReasonDiagn(Boolean defaultValues){
        if (defaultValues){
            deathReasonDiagnId = null;

            deathReasonId = new DeathReason(true);
            diagnType = null;
            description = "";
            years = null;
            months = null;
            days = null;
            hours = null;
            minutes = null;
            timeUnknown = null; //TODO проверить поле

            mkbId = null;
        }
    }

}
