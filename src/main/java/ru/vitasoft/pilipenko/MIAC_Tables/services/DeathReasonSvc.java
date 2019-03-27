package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.DeathReason;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.DeathReasonRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeathReasonSvc {

    private final DeathReasonRepository deathReasonRepository;

    @Autowired
    public DeathReasonSvc(DeathReasonRepository deathReasonRepository) {
        this.deathReasonRepository = deathReasonRepository;
    }

    public DeathReason getEmptyDeathReasonSvc(){

        return new DeathReason(true);

    }

    public JSONObject save(DeathReason deathReason) {

        DeathReason respondFromServ;
        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        respondFromServ = deathReasonRepository.save(deathReason);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getDeathReasonId().toString());
        }else{
            jsonMap.put("message", "error");
        }

        response = new JSONObject(jsonMap);
        return response;
    }
}
