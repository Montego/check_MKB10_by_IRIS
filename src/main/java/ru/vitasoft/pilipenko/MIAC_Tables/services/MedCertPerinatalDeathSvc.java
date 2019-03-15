package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertPerinatalDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertPerinatalDeathRepository;
import org.json.simple.JSONObject;

@Service
public class MedCertPerinatalDeathSvc {

    @Autowired
    MedCertPerinatalDeathRepository medCertPerinatalDeathRepository;

    public MedCertPerinatalDeath getEmptyMedCertPerinatalSvc(){

        return new MedCertPerinatalDeath(true);

    }

    public Iterable<MedCertPerinatalDeath> medCertPerinatalDeathFindAll() {
        return medCertPerinatalDeathRepository.findAll();
    }

    public JSONObject save(MedCertPerinatalDeath medCertPerinatalDeath){

        JSONObject response = new JSONObject();
        MedCertPerinatalDeath respondFromServ;

        respondFromServ = medCertPerinatalDeathRepository.save(medCertPerinatalDeath);

        if (respondFromServ != null){
            response.put("message", "ok - id: " + respondFromServ.getId().toString());
        }else{
            response.put("message", "error");
        }

        return response;

    }


}
