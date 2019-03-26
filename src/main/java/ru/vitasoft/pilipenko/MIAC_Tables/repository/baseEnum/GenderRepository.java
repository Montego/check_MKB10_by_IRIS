package ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.Gender;

public interface GenderRepository extends JpaRepository<Gender,Integer> {
}
