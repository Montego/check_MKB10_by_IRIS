package ru.vitasoft.romanov.IRIS_scriptUsing.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String certificateKey;

    private String codeOne;

    private String codeTwo;

    private String codeThree;

    private String codeFour;

    private String status;

    private String logText;

    LocalDate dateTime;
}
