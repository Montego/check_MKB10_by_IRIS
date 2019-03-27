package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.DeathReasonDiagn;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.DeathReasonDiagnRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeathReasonDiagnSvc {

    private final DeathReasonDiagnRepository deathReasonDiagnRepository;

    @Autowired
    public DeathReasonDiagnSvc(DeathReasonDiagnRepository deathReasonDiagnRepository) {
        this.deathReasonDiagnRepository = deathReasonDiagnRepository;
    }

    public DeathReasonDiagn getEmptyDeathReasonDiagnSvc(){

        return new DeathReasonDiagn(true);

    }

    public JSONObject save(DeathReasonDiagn deathReasonDiagn) {

        DeathReasonDiagn respondFromServ;
        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        respondFromServ = deathReasonDiagnRepository.save(deathReasonDiagn);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getDeathReasonDiagnId().toString());
        }else{
            jsonMap.put("message", "error");
        }

        response = new JSONObject(jsonMap);
        return response;
    }
}
