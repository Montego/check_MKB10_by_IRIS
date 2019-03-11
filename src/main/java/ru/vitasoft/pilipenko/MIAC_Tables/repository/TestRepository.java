package ru.vitasoft.pilipenko.MIAC_Tables.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.model.TestUsers;

public interface TestRepository extends CrudRepository<TestUsers,Integer> {

    TestUsers findByUserId(Integer UserId);

}


