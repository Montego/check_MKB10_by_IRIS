package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertSvc;
import org.json.simple.JSONObject;


@RestController
@RequestMapping("/rest")
public class MedCertController {

    private final MedCertSvc medCertSvc;

    @Autowired
    public MedCertController(MedCertSvc medCertSvc) {
        this.medCertSvc = medCertSvc;
    }

//GET

    //TODO Убрать полную выборку
    @GetMapping("/getAllMedCert")
    public Iterable<MedCert> getAllMedCert(){

        return medCertSvc.medCertFindAll();

    }

    @GetMapping("/getEmptyMedCert")
    public MedCert getEmptyMedCert(){

        return medCertSvc.getEmptyMedCertSvc();

    }

//POST

    @PostMapping("/addMedCert")
    public JSONObject addMedCertBirth(@RequestBody MedCert medCertPerinatalDeath)  {

        return medCertSvc.save(medCertPerinatalDeath);

    }


}
