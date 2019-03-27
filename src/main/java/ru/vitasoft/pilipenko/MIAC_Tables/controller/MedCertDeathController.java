package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertDeathSvc;
import org.json.simple.JSONObject;

@RestController
@RequestMapping("/rest")
public class MedCertDeathController {

    private final MedCertDeathSvc medCertDeathSvc;

    @Autowired
    public MedCertDeathController(MedCertDeathSvc medCertDeathSvc) {
        this.medCertDeathSvc = medCertDeathSvc;
    }

//GET

    @GetMapping("/getEmptyMedCertDeath")
    public MedCertDeath getEmptyMedCert(){
        return medCertDeathSvc.getEmptyMedCertSvc();
    }

//POST

    @PostMapping("/addMedCertDeath")
    public JSONObject addMedCertDeath(@RequestBody MedCertDeath medCertPerinatalDeath)  {
        return medCertDeathSvc.save(medCertPerinatalDeath);
    }


}
