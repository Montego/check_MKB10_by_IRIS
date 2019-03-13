package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_ActRecord")
public class ActRecords {

    @Id
    private Integer act_record_id;
    private Integer number;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime date;

    @ManyToOne
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
