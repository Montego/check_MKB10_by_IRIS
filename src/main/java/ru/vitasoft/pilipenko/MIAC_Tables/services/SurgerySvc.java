package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Surgery;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.SurgeryRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class SurgerySvc {

    private final SurgeryRepository surgeryRepository;

    @Autowired
    public SurgerySvc(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    public Surgery getEmptySurgery(){
        return new Surgery(true);
    }

    public JSONObject save(Surgery surgery) {

        Surgery respondFromServ;
        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        respondFromServ = surgeryRepository.save(surgery);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getSurgeryId().toString());
        }else{
            jsonMap.put("message", "error");
        }

        response = new JSONObject(jsonMap);
        return response;
    }
}
