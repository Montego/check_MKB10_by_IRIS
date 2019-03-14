package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertBirthSvc;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertSvc;

@RestController
@RequestMapping("/rest")
public class MedCertBirthController {

    @Autowired
    MedCertBirthSvc medCertBirthSvc;

    @GetMapping("/GetEmptyMedCertBirth")
    public MedCertBirth getEmptyMedCert(){

        return medCertBirthSvc.getEmptyMedCertSvc();

    }

}
