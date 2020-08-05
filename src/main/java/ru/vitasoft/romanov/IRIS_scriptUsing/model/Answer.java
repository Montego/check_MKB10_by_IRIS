package ru.vitasoft.romanov.IRIS_scriptUsing.model;

import lombok.Data;

@Data
public class Answer {

    private long id;

    String status = "unchecked";

    String textAnswer;
}
