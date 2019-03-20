package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.model.comparison.SearchElement;
import ru.vitasoft.pilipenko.MIAC_Tables.model.comparison.SearchParams;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertBirthRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.services.MedCertBirthSvc;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import static ru.vitasoft.pilipenko.MIAC_Tables.repository.specifications.MedCertsSpecification.*;


@RestController
@RequestMapping("/rest")
public class MedCertBirthController {

    @Autowired
    MedCertBirthSvc medCertBirthSvc;

    //TODO Убрать полную выборку
    @GetMapping("/GetAllMedCertBirth")
    public Iterable<MedCertBirth> getAllMedCertBirth(){
        return medCertBirthSvc.medCertBirthFindAll();
    }

    @Autowired
    MedCertBirthRepository medCertBirthRepository;
    @PostMapping("/SearchMedCertBirth")
    public Iterable<MedCertBirth> getMedCertBirth(@RequestBody SearchParams params) {

        ArrayList<SearchElement> paramsAL = params.toArrayList();

        Specification<MedCertBirth> sp  = Specification.where(whereAndStart());

        for (SearchElement param:paramsAL) {
            sp = sp.and(addSearchElement(param));
        }

        return medCertBirthRepository.findAll(sp);
    }

    @GetMapping("/GetEmptyMedCertBirth")
    public MedCertBirth getEmptyMedCertBirth(){

        return medCertBirthSvc.getEmptyMedCertBirthSvc();

    }

    @PostMapping("/AddMedCertBirth")
    public JSONObject addMedCertBirth(@RequestBody MedCertBirth medCertBirth)  {

        return medCertBirthSvc.save(medCertBirth);

    }

}
