package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertSvc;

@RestController
@RequestMapping("/rest")
public class MedCertController {

    @Autowired
    MedCertSvc medCertSvc;

    @GetMapping("/GetEmptyMedCert")
    public MedCert getEmptyMedCert(){

        return medCertSvc.getEmptyMedCertSvc();

    }

}
