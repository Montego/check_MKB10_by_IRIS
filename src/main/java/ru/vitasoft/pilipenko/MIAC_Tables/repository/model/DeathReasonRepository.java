package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.DeathReason;

public interface DeathReasonRepository extends JpaRepository<DeathReason,Integer> {
}
