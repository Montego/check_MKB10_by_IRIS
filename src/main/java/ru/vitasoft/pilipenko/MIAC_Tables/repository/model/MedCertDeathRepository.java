package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.repository.CrudRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertDeath;

import java.util.Optional;

public interface MedCertDeathRepository extends CrudRepository<MedCertDeath,Integer> {

    Optional<MedCertDeath> findById(Integer Id);

}


