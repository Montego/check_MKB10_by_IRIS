package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertPerinatalDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertPerinatalDeathRepository;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Service
public class MedCertPerinatalDeathSvc {

    private final MedCertPerinatalDeathRepository medCertPerinatalDeathRepository;

    @Autowired
    public MedCertPerinatalDeathSvc(MedCertPerinatalDeathRepository medCertPerinatalDeathRepository) {
        this.medCertPerinatalDeathRepository = medCertPerinatalDeathRepository;
    }

    public MedCertPerinatalDeath getEmptyMedCertPerinatalSvc(){

        return new MedCertPerinatalDeath(true);

    }

    public Iterable<MedCertPerinatalDeath> medCertPerinatalDeathFindAll() {
        return medCertPerinatalDeathRepository.findAll();
    }

    public JSONObject save(MedCertPerinatalDeath medCertPerinatalDeath){

        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();
        MedCertPerinatalDeath respondFromServ;

        respondFromServ = medCertPerinatalDeathRepository.save(medCertPerinatalDeath);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getId().toString());
        }else{
            jsonMap.put("message", "error");
        }
        response = new JSONObject(jsonMap);

        return response;

    }
}
