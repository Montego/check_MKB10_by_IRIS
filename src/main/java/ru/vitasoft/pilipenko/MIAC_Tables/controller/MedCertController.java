package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;

@RestController
@RequestMapping("/rest")
public class MedCertController {

    @GetMapping("/GetEmptyMedCert")
    public MedCert getEmptyMedCert(){

        return new MedCert(true);

    }

}
