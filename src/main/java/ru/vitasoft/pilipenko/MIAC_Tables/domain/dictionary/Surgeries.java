package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Mkb10")
public class Surgeries {

    @Id
    private Integer surgeryId;

    @ManyToOne
    @JoinColumn(name = "DeathReasonId")
    private DeathReasons deathReasonId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "medCertDeathId")
    private MedCertDeath medCertDeathId;                  //enum


    //конструктор для информативного заполения JSON
    public Surgeries(Boolean defaultValues){
        if (defaultValues){

            this.setSurgeryId(-1);
            this.setDeathReasonId(new DeathReasons(true));
            this.setDate(LocalDateTime.parse("0001-01-01T00:00:00"));
            this.setMedCertDeathId(new MedCertDeath(true));

        }
    }


}
