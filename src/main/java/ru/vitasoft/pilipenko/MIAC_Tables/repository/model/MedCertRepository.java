package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.repository.CrudRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCert;

public interface MedCertRepository extends CrudRepository<MedCert,Integer> {

    MedCert findByMedCertId(Integer MedCertId);

}


