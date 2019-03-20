package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertDeathRepository;
import org.json.simple.JSONObject;

@Service
public class MedCertDeathSvc {

    @Autowired
    MedCertDeathRepository medCertDeathRepository;

    public Iterable<MedCertDeath> medCertDeathFindAll() {
        return medCertDeathRepository.findAll();
    }

    public JSONObject save(MedCertDeath medCertPerinatalDeath){

        JSONObject response = new JSONObject();
        MedCertDeath respondFromServ;

        respondFromServ = medCertDeathRepository.save(medCertPerinatalDeath);

        if (respondFromServ != null){
            response.put("message", "ok - id: " + respondFromServ.getId().toString());
        }else{
            response.put("message", "error");
        }

        return response;

    }

    public MedCertDeath getEmptyMedCertSvc(){

        return new MedCertDeath(true);

    }




}
