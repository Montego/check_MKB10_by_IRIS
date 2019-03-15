package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900DateOnly;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Mkb10")
public class Surgeries {

    @Positive
    @Id
    private Integer surgeryId;

    @ManyToOne
    @JoinColumn(name = "DeathReasonId")
    private DeathReasons deathReasonId;

    @Past
    @NullOrAfter1900DateOnly
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "medCertDeathId")
    private MedCertDeath medCertDeathId;                  //enum


    //конструктор для информативного заполения JSON
    public Surgeries(Boolean defaultValues){
        if (defaultValues){

            this.setSurgeryId(-1);
            this.setDeathReasonId(new DeathReasons(true));
            this.setDate(LocalDate.parse("0001-01-01"));
            this.setMedCertDeathId(new MedCertDeath(true));

        }
    }


}
