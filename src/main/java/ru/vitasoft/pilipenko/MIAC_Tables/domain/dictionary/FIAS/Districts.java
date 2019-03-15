package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Districts")
public class Districts {
    @Positive
    @Id
    private Integer disctrictId;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    //конструктор для информативного заполения JSON
    public Districts(Boolean defaultValues){
        if (defaultValues){
            this.setDisctrictId(-1);
            this.setName("");
        }
    }
}
