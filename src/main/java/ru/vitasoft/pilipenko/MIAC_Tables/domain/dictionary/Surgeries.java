package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "D_Mkb10")
public class Surgeries {

    @Id
    private Integer surgeryId;

    @ManyToOne
    @JoinColumn(name = "DeathReasonId")
    private DeathReasons deathReasonId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime date;

}
