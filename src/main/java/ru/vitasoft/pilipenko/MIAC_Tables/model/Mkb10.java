package ru.vitasoft.pilipenko.MIAC_Tables.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
//@Entity
public class Mkb10 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String a;
    String b;
    String c;
    String d;
}
