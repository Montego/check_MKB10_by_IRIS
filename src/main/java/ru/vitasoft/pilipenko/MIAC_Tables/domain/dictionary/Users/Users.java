package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Users")
public class Users {

    @Positive
    @Id
    private Integer userId;

    @Size(max = 255)
    private String email;
    @Size(max = 255)
    private String password;

    //конструктор для информативного заполения JSON
    public Users(Boolean defaultValues){
        if (defaultValues){
            this.setUserId(-1);
            this.setEmail("");
            this.setPassword("");
        }
    }
}
