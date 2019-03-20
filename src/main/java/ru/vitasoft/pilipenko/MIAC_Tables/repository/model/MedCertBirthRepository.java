package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;

import java.util.Optional;

public interface MedCertBirthRepository extends CrudRepository<MedCertBirth,Integer>, JpaSpecificationExecutor<MedCertBirth> {

    Optional<MedCertBirth> findById(Integer Id);

}


