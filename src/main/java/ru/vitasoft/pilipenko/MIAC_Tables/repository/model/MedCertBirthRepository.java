package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.repository.CrudRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;

import java.util.Optional;

public interface MedCertBirthRepository extends CrudRepository<MedCertBirth,Integer> {

    Optional<MedCertBirth> findById(Integer Id);

}


