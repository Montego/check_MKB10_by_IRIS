package ru.vitasoft.romanov.IRIS_scriptUsing.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
//@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String status = "Unchecked";

    String textAnswer;
}