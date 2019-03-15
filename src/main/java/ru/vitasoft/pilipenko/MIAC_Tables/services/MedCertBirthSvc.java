package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertBirthRepository;

@Service
public class MedCertBirthSvc {

    @Autowired
    MedCertBirthRepository medCertBirthRepository;

    public MedCertBirth getEmptyMedCertBirthSvc(){

        return new MedCertBirth(true);

    }

    public Iterable<MedCertBirth> medCertBirthFindAll() {

        return medCertBirthRepository.findAll();

    }

    public JSONObject save(MedCertBirth medCertPerinatalDeath) {

        JSONObject response = new JSONObject();
        MedCertBirth respondFromServ;

        respondFromServ = medCertBirthRepository.save(medCertPerinatalDeath);

        if (respondFromServ != null){
            response.put("message", "ok - id: " + respondFromServ.getId().toString());
        }else{
            response.put("message", "error");
        }

        return response;

    }
}
