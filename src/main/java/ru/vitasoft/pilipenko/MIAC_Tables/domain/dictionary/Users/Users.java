package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "D_Users")
public class Users {

    @Id
    private Integer userId;

    private String email;
    private String password;

}
