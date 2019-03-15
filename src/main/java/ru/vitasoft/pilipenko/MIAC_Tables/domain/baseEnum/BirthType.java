package ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FamilyStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
@Table(name = "BE_BirthType")
public class BirthType {
    @PositiveOrZero
    @Id
    private Integer id;
    @NotNull
    @Size(min = 1)
    private String name;


//тестовое поле удалить после отладки
    @JsonFormat(pattern = "dd.MM.yyyy'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime enrollmentDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FamilyStatusId")
    private FamilyStatus familyStatusId;           //FK

//


    //конструктор для информативного заполения JSON
    public BirthType(Boolean defaultValues){
        if (defaultValues){
            this.setId(-1);
            this.setName("");
            this.setEnrollmentDate(LocalDateTime.parse("0001-01-01T00:00:00"));
            this.setFamilyStatusId(new FamilyStatus(true));
        }
    }
}
