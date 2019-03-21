package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class MedCertSvc {

    private final MedCertRepository medCertRepository;

    @Autowired
    public MedCertSvc(MedCertRepository medCertRepository) {
        this.medCertRepository = medCertRepository;
    }

    public Iterable<MedCert> medCertFindAll() {

        return medCertRepository.findAll();
    }

    public MedCert getEmptyMedCertSvc(){

        return new MedCert(true);

    }

    public JSONObject save(MedCert medCert) {

        MedCert respondFromServ;
        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        respondFromServ = medCertRepository.save(medCert);

        if (respondFromServ != null){
            jsonMap.put("message", "ok - id: " + respondFromServ.getMedCertId().toString());
        }else{
            jsonMap.put("message", "error");
        }

        response = new JSONObject(jsonMap);

        return response;

    }
}
