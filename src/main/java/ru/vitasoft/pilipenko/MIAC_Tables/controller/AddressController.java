package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Address;
import ru.vitasoft.pilipenko.MIAC_Tables.services.AddressSvc;

@RestController
@RequestMapping("/rest")
public class AddressController {

    private final ru.vitasoft.pilipenko.MIAC_Tables.services.AddressSvc addressSvc;

    @Autowired
    public AddressController(AddressSvc addressSvc) {
        this.addressSvc = addressSvc;
    }

//GET

    @GetMapping("/getEmptyAddress")
    public Address getEmptyAddress(){

        return addressSvc.getEmptyAddress();

    }

//POST

    @PostMapping("/addAddress")
    public JSONObject addAddress(@RequestBody Address address)  {

        return addressSvc.save(address);

    }
}
