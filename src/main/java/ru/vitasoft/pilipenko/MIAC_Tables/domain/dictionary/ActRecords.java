package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.vitasoft.pilipenko.MIAC_Tables.validator.NullOrAfter1900;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.time.LocalDateTime;

//TODO убрать каскадирование

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_ActRecord")
public class ActRecords {

    @Positive
    @Id
    private Integer act_record_id;

    @NotNull
    @Min(1)
    private Integer number;

    @NullOrAfter1900
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime date;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "CivilRegistryDepartments")
    private CivilRegistryDepartments departmentId;  //FK


    //конструктор для информативного заполения JSON
    public ActRecords(Boolean defaultValues){
        if (defaultValues){
            this.setAct_record_id(-1);
            this.setNumber(-1);
            this.setDate(LocalDateTime.parse("0001-01-01T00:00:00"));
            this.setDepartmentId(new CivilRegistryDepartments(true));
        }
    }
}
