package ru.vitasoft.pilipenko.MIAC_Tables.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TestMedCod")
public class TestMedCod {
    private String certificateKey;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "smallint")
    private Integer lineNb;
    @Column(columnDefinition = "nvarchar(max)")
    private String textLine="";
    private String codeLine;
    private String intervalLine="";
    private String codeOnly="";
    private String lineCoded;
}
