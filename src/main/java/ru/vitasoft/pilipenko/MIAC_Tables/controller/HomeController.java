package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.model.TestMedCod;
import ru.vitasoft.pilipenko.MIAC_Tables.model.TestMedCodRepository;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    TestMedCodRepository testMedCodRepository;
    @GetMapping("/get")
    public List<TestMedCod> findAll(){
        return testMedCodRepository.findAll();
    }
}
