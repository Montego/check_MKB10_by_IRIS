package ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "D_Addresses")
public class Addresses {
    @Positive
    @Id
    private Integer addressId;
    @Size(max = 255)
    private String refType;

    @Positive
    private Integer refId;

    @Positive
    private Integer addressType;

    @Size(max = 255)
    private String roomNumber;
    @Size(max = 255)
    private String building;
    @Size(max = 255)
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

    //конструктор для информативного заполения JSON
    public Addresses(Boolean defaultValues){
        if (defaultValues){
            this.setAddressId(-1);
            this.setRefType("");
            this.setRefId(-1);
            this.setAddressType(-1);
            this.setRoomNumber("");
            this.setBuilding("");
            this.setStreet("");
            this.setDisctrictId(new Districts(true));                              //FK
            this.setCityId(new Cities(true));                                      //FK
            this.setSubjectOfFederationId(new SubjectsOfFederation(true));         //FK
            this.setCountryId(new Countries(true));                                //FK
            this.setLocalityId(new Localities(true));                              //FK
        }
    }
}
