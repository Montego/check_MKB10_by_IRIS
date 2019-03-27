package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Recepient;

public interface RecepientRepository extends JpaRepository<Recepient,Integer> {
}
