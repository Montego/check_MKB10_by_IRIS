package ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.CertStatus;

public interface CertStatusRepository extends JpaRepository<CertStatus,Integer> {
}
