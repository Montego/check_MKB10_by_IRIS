package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "D_Addresses")
public class Addresses {

    @Id
    private Integer addressId;
    private String refType;
    private Integer refId;
    private Integer addressType;

    private String roomNumber;
    private String building;
    private String street;

    @ManyToOne
    @JoinColumn(name = "DisctrictId")
    private Districts disctrictId;                              //FK

    @ManyToOne
    @JoinColumn(name = "CityId")
    private Cities cityId;                                      //FK

    @ManyToOne
    @JoinColumn(name = "SubjectOfFederationId")
    private SubjectsOfFederation subjectOfFederationId;         //FK

    @ManyToOne
    @JoinColumn(name = "CountryId")
    private Countries countryId;                                //FK

    @ManyToOne
    @JoinColumn(name = "LocalityId")
    private Localities localityId;                              //FK

}
