package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertPerinatalDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertPerinatalDeathSvc;

@RestController
@RequestMapping("/rest")
public class MedCertPerinatalDeathController {

    @Autowired
    MedCertPerinatalDeathSvc medMedCertPerinatalDeath;

    //TODO Убрать полную выборку
    @GetMapping("/GetAllMedCertPerinatalDeath")
    public Iterable<MedCertPerinatalDeath> medCertPerinatalDeathFindAll() {
        return medMedCertPerinatalDeath.medCertPerinatalDeathFindAll();
    }

    @GetMapping("/GetEmptyMedCertPerinatalDeath")
    public MedCertPerinatalDeath getEmptyMedCert(){

        return medMedCertPerinatalDeath.getEmptyMedCertPerinatalSvc();

    }

    @PostMapping("/AddMedCertPerinatalDeath")
    public JSONObject addMedCertPerinatalDeath(@RequestBody MedCertPerinatalDeath medCertPerinatalDeath)  {

        return medMedCertPerinatalDeath.save(medCertPerinatalDeath);

    }

}
