package ru.vitasoft.pilipenko.MIAC_Tables.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.DeathReasonDiagn;

public interface DeathReasonDiagnRepository extends JpaRepository<DeathReasonDiagn,Integer> {
}
