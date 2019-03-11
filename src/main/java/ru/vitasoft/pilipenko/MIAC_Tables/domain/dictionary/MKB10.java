package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "D_Mkb10")
public class MKB10 {
    @Id
    private String mkbId;
    private String name;
}
