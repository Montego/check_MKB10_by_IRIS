package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertBirthSvc;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertDeathSvc;

@RestController
@RequestMapping("/rest")
public class MedCertDeathController {

    @Autowired
    MedCertDeathSvc medCertDeathSvc;

    @GetMapping("/GetEmptyMedCertDeath")
    public MedCertDeath getEmptyMedCert(){

        return medCertDeathSvc.getEmptyMedCertSvc();

    }

}
