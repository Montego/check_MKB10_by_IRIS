package ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByEmail(String email);
}


