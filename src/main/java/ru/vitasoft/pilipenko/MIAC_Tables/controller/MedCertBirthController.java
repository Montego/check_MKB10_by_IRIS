package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;

import ru.vitasoft.pilipenko.MIAC_Tables.model.comparison.SearchParams;

import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertBirthSvc;
import org.json.simple.JSONObject;

@RestController
@RequestMapping("/rest")
public class MedCertBirthController {

    private final MedCertBirthSvc medCertBirthSvc;

    @Autowired
    public MedCertBirthController(MedCertBirthSvc medCertBirthSvc) {
        this.medCertBirthSvc = medCertBirthSvc;
    }

//GET

    @GetMapping("/getEmptyMedCertBirth")
    public MedCertBirth getEmptyMedCertBirth(){
        return medCertBirthSvc.getEmptyMedCertBirthSvc();
    }

//POST

    @PostMapping("/addMedCertBirth")
    public JSONObject addMedCertBirth(@RequestBody MedCertBirth medCertBirth)  {
        return medCertBirthSvc.save(medCertBirth);
    }

    /**
     * Выполняет поиск свидетельств о рождении по указанной в классе SearchParams структуре параметров
     *
      * @param params - SearchParams - значения параметров, если параметр не указан необходимо указать null тогда
     *               он не будет участвовать в фильтрации
     * @return Iterable<MedCertBirth> - возвращает список свидетельств подходящих по описанию
     */
    @PostMapping("/searchMedCertBirth")
    public Iterable<MedCertBirth> getMedCertBirth(@RequestBody SearchParams params) {
        return medCertBirthSvc.getMedCertBirth(params);
    }

}
