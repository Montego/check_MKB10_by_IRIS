package ru.vitasoft.romanov.IRIS_scriptUsing.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Mkb10 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String a;
    String b;
    String c;
    String d;
}
