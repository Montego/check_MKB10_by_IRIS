package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertBirthSvc;
import org.json.simple.JSONObject;


@RestController
@RequestMapping("/rest")
public class MedCertBirthController {

    @Autowired
    MedCertBirthSvc medCertBirthSvc;

    //TODO Убрать полную выборку
    @GetMapping("/GetAllMedCertBirth")
    public Iterable<MedCertBirth> getAllMedCertBirth(){

        return medCertBirthSvc.medCertBirthFindAll();

    }

    @GetMapping("/GetEmptyMedCertBirth")
    public MedCertBirth getEmptyMedCertBirth(){

        return medCertBirthSvc.getEmptyMedCertBirthSvc();

    }

    @PostMapping("/AddMedCertBirth")
    public JSONObject addMedCertBirth(@RequestBody MedCertBirth medCertPerinatalDeath)  {

        return medCertBirthSvc.save(medCertPerinatalDeath);

    }

}
