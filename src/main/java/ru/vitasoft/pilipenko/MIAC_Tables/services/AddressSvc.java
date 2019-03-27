package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Address;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.AddressRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressSvc {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressSvc(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getEmptyAddress(){

        return new Address(true);

    }

    public JSONObject save(Address address) {

        Address respondFromServ;
        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        respondFromServ = addressRepository.save(address);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getAddressId().toString());
        }else{
            jsonMap.put("message", "error");
        }

        response = new JSONObject(jsonMap);
        return response;
    }
}
