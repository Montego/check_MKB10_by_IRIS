package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;

@Service
public class MedCertBirthSvc {

    public MedCertBirth getEmptyMedCertSvc(){

        return new MedCertBirth(true);

    }

}
