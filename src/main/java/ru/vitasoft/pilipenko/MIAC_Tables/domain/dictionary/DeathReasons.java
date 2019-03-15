package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_DeathReasons")
public class DeathReasons {

    @Positive
    @Id
    private Integer deathReasonId;

    @NotNull
    @Size(min = 1)
    private String refType;

    @Positive
    private Integer refId;

    private Boolean roadAccidentIn30Days;
    private Boolean roadAccidentIn7Days;
    private Boolean deathReasonUnknown;

    @Size(max = 255)
    private String deathReasonState;

    //конструктор для информативного заполения JSON
    public DeathReasons(Boolean defaultValues){
        if (defaultValues){
            this.setDeathReasonId(-1);
            this.setRefType("");
            this.setRefId(-1);
            this.setRoadAccidentIn30Days(false);
            this.setRoadAccidentIn7Days(false);
            this.setDeathReasonUnknown(false);
            this.setDeathReasonState("");
        }
    }
}
