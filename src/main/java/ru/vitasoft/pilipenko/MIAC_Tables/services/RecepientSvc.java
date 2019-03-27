package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Recepient;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.RecepientRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecepientSvc {

    private final RecepientRepository recepientRepository;

    @Autowired
    public RecepientSvc(RecepientRepository recepientRepository) {
        this.recepientRepository = recepientRepository;
    }

    public Recepient getEmptyRecepient(){
        return new Recepient(true);
    }

    public JSONObject save(Recepient recepient) {

        Recepient respondFromServ;
        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        respondFromServ = recepientRepository.save(recepient);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getRecepientId().toString());
        }else{
            jsonMap.put("message", "error");
        }

        response = new JSONObject(jsonMap);
        return response;
    }
}
