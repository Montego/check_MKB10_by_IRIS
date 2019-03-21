package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertDeathRepository;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Service
public class MedCertDeathSvc {

    private final MedCertDeathRepository medCertDeathRepository;

    @Autowired
    public MedCertDeathSvc(MedCertDeathRepository medCertDeathRepository) {
        this.medCertDeathRepository = medCertDeathRepository;
    }

    public Iterable<MedCertDeath> medCertDeathFindAll() {
        return medCertDeathRepository.findAll();
    }

    public JSONObject save(MedCertDeath medCertPerinatalDeath){

        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        MedCertDeath respondFromServ;

        respondFromServ = medCertDeathRepository.save(medCertPerinatalDeath);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getId().toString());
        } else {
            jsonMap.put("message", "error");
        }

        response = new JSONObject(jsonMap);

        return response;

    }

    public MedCertDeath getEmptyMedCertSvc(){

        return new MedCertDeath(true);

    }




}
