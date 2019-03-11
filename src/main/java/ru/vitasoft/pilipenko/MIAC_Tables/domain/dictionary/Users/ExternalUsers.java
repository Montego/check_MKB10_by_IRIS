package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "D_ExternalUsers")
public class ExternalUsers {
    @Id
    private Integer externalUserId;
}
