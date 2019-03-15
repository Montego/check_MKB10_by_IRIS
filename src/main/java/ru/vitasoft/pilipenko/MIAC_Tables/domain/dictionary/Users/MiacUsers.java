package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_MiacUsers")
public class MiacUsers {
    @Positive
    @Id
    private Integer miacUserId;

    //конструктор для информативного заполения JSON
    public MiacUsers(Boolean defaultValues){
        if (defaultValues){
            this.setMiacUserId(-1);
        }
    }

}
