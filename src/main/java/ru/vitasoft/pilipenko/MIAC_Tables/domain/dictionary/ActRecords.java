package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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

}
