package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;

@Service
public class MedCertDeathSvc {

    public MedCertDeath getEmptyMedCertSvc(){

        return new MedCertDeath(true);

    }

}
