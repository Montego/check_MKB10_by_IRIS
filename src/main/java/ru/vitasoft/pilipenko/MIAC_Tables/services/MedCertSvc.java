package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertRepository;
import org.json.simple.JSONObject;

@Service
public class MedCertSvc {

    @Autowired
    MedCertRepository medCertRepository;

    public Iterable<MedCert> medCertFindAll() {

        return medCertRepository.findAll();

    }

    public MedCert getEmptyMedCertSvc(){

        return new MedCert(true);

    }

    public JSONObject save(MedCert medCertPerinatalDeath) {

        JSONObject response = new JSONObject();
        MedCert respondFromServ;

        respondFromServ = medCertRepository.save(medCertPerinatalDeath);

        if (respondFromServ != null){
            response.put("message", "ok - id: " + respondFromServ.getMedCertId().toString());
        }else{
            response.put("message", "error");
        }

        return response;
    }
}
