package ru.vitasoft.romanov.IRIS_scriptUsing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TestMedCod")
public class TestMedCod {
    private String certificateKey;
    @Id
    @Column(columnDefinition = "smallint")
    private Integer lineNb;
    @Column(columnDefinition = "nvarchar(max)")
    private String textLine = "";
    private String codeLine;
    private String intervalLine = "";
    private String codeOnly = "";
    private String lineCoded;
}
