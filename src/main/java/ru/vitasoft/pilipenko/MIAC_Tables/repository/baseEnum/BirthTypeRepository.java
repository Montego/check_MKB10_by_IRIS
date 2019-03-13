package ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum;

import org.springframework.data.repository.CrudRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.BirthType;
import ru.vitasoft.pilipenko.MIAC_Tables.model.TestUsers;

public interface BirthTypeRepository extends CrudRepository<BirthType,Integer> {
}


