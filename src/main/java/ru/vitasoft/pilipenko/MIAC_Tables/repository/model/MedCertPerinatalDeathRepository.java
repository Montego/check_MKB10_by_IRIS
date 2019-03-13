package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.repository.CrudRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertPerinatalDeath;

import java.util.Optional;

public interface MedCertPerinatalDeathRepository extends CrudRepository<MedCertPerinatalDeath,Integer> {

    Optional<MedCertPerinatalDeath> findById(Integer Id);

}


