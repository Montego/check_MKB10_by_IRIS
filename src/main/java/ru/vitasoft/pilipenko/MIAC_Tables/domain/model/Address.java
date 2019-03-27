package ru.vitasoft.pilipenko.MIAC_Tables.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.AddressType;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.Locality;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @PositiveOrZero
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String refType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressType")
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locality")
    private Locality locality;

    @Size(max = 200)
    private String description;

    private Integer refId;//TODO возможно нужно указать NotNull

    //конструктор для информативного заполения JSON
    public Address(Boolean defaultValues){
        if (defaultValues){
            this.addressId      = -1;
            this.refType        = "";
            this.addressType    = null;
            this.locality       = null;
            this.description    = "";
            this.refId          = -1;
        }
    }
}
