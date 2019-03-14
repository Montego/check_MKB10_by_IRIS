package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertPerinatalDeath;

@Service
public class MedCertPerinatalDeathSvc {

    public MedCertPerinatalDeath getEmptyMedCertPerinatalSvc(){

        return new MedCertPerinatalDeath(true);

    }

}
