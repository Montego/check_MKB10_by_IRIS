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
@Table(name = "D_identityDoc")
public class IdentityDoc {
    @PositiveOrZero
    @Id
    @Column(name = "identityDocId")
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String name;

    //конструктор для информативного заполения JSON
    public IdentityDoc(Boolean defaultValues){
        if (defaultValues){

            this.setName("");
        }
    }
}
