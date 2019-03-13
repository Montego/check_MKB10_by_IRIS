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
@Table(name = "D_DeathReasons")
public class DeathReasons {
    @Id
    private Integer deathReasonId;

    private String refType;
    private Integer refId;

    private Boolean roadAccidentIn30Days    = false;
    private Boolean roadAccidentIn7Days     = false;
    private Boolean deathReasonUnknown      = false;

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
