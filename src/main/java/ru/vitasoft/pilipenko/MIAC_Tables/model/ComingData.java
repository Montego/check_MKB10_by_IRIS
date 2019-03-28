package ru.vitasoft.pilipenko.MIAC_Tables.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
//@Entity
public class ComingData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Mkb10 mkb10;

    Timestamp timestamp;

}
