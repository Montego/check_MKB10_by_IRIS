package ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.IdentityDoc;

public interface IdentityDocRepository extends JpaRepository<IdentityDoc,Integer> {
}
