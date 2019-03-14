package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;

@Service
public class MedCertSvc {

    public MedCert getEmptyMedCertSvc(){

        return new MedCert(true);

    }

}
