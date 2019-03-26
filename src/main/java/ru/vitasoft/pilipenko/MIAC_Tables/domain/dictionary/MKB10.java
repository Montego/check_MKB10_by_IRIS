package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_mkb10")
public class MKB10 {
    @PositiveOrZero
    @Id
    private Integer mkb10Id;
    @NotNull
    @Size(max = 100)
    private String name;

    //конструктор для информативного заполения JSON
    public MKB10(Boolean defaultValues){
        if (defaultValues){
            this.setMkb10Id(-1);
            this.setName("");
        }
    }
}
