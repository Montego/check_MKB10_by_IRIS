package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertPerinatalDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertPerinatalDeathSvc;

@RestController
@RequestMapping("/rest")
public class MedCertPerinatalDeathController {

    private final MedCertPerinatalDeathSvc medMedCertPerinatalDeath;

    @Autowired
    public MedCertPerinatalDeathController(MedCertPerinatalDeathSvc medMedCertPerinatalDeath) {
        this.medMedCertPerinatalDeath = medMedCertPerinatalDeath;
    }

//GET

    //TODO Убрать полную выборку
    @GetMapping("/GetAllMedCertPerinatalDeath")
    public Iterable<MedCertPerinatalDeath> medCertPerinatalDeathFindAll() {
        return medMedCertPerinatalDeath.medCertPerinatalDeathFindAll();
    }

    @GetMapping("/GetEmptyMedCertPerinatalDeath")
    public MedCertPerinatalDeath getEmptyMedCert(){

        return medMedCertPerinatalDeath.getEmptyMedCertPerinatalSvc();

    }

//POST

    @PostMapping("/AddMedCertPerinatalDeath")
    public JSONObject addMedCertPerinatalDeath(@RequestBody MedCertPerinatalDeath medCertPerinatalDeath)  {

        return medMedCertPerinatalDeath.save(medCertPerinatalDeath);

    }

}
