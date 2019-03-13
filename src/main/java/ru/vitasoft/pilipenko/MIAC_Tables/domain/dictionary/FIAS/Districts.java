package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Districts")
public class Districts {
    @Id
    private Integer disctrictId;
    private String name;

    //конструктор для информативного заполения JSON
    public Districts(Boolean defaultValues){
        if (defaultValues){
            this.setDisctrictId(-1);
            this.setName("");
        }
    }
}
