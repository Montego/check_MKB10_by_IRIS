package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertPerinatalDeath;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertDeathSvc;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertPerinatalDeathSvc;

@RestController
@RequestMapping("/rest")
public class MedCertPerinatalDeathController {

    @Autowired
    MedCertPerinatalDeathSvc medMedCertPerinatalDeath;

    @GetMapping("/GetEmptyMedCertPerinatalDeath")
    public MedCertPerinatalDeath getEmptyMedCert(){

        return medMedCertPerinatalDeath.getEmptyMedCertPerinatalSvc();

    }

}
