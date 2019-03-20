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

    //конструктор для информативного заполения JSON
    public BirthType(Boolean defaultValues){
        if (defaultValues){
            this.setId(-1);
            this.setName("");
        }
    }
}
