package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertDeathSvc;
import org.json.simple.JSONObject;

@RestController
@RequestMapping("/rest")
public class MedCertDeathController {

    @Autowired
    MedCertDeathSvc medCertDeathSvc;

    //TODO Убрать полную выборку
    @GetMapping("/GetAllMedCertDeath")
    public Iterable<MedCertDeath> getAllMedCertDeath(){

        return medCertDeathSvc.medCertDeathFindAll();

    }

    @GetMapping("/GetEmptyMedCertDeath")
    public MedCertDeath getEmptyMedCert(){

        return medCertDeathSvc.getEmptyMedCertSvc();

    }

    @PostMapping("/AddMedCertDeath")
    public JSONObject addMedCertDeath(@RequestBody MedCertDeath medCertPerinatalDeath)  {

        return medCertDeathSvc.save(medCertPerinatalDeath);

    }


}
