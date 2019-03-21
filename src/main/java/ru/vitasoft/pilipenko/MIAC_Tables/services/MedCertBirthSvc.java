package ru.vitasoft.pilipenko.MIAC_Tables.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.model.comparison.SearchElement;
import ru.vitasoft.pilipenko.MIAC_Tables.model.comparison.SearchParams;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.model.MedCertBirthRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ru.vitasoft.pilipenko.MIAC_Tables.repository.specifications.MedCertsSpecification.addSearchElement;
import static ru.vitasoft.pilipenko.MIAC_Tables.repository.specifications.MedCertsSpecification.whereAndStart;

@Service
public class MedCertBirthSvc {

    private final MedCertBirthRepository medCertBirthRepository;

    @Autowired
    public MedCertBirthSvc(MedCertBirthRepository medCertBirthRepository) {
        this.medCertBirthRepository = medCertBirthRepository;
    }

    public MedCertBirth getEmptyMedCertBirthSvc(){

        return new MedCertBirth(true);

    }

    public Iterable<MedCertBirth> medCertBirthFindAll() {

        return medCertBirthRepository.findAll();

    }

    public JSONObject save(MedCertBirth medCertBirth) {

        JSONObject response;
        Map<String,String> jsonMap = new HashMap<>();

        MedCertBirth respondFromServ;

        respondFromServ = medCertBirthRepository.save(medCertBirth);

        if (respondFromServ != null){
            jsonMap.put("message","MedCert - created - id: " + respondFromServ.getId().toString());//
        }else{
            jsonMap.put("message", "Error during saving");
        }

        response = new JSONObject(jsonMap);

        return response;

    }

    /** Производит поиск свидетельств о рождениии по указанной структуре параметров.
     * Структура автоматически преобразуется в список внутри функции.
     * Чтобы исключить свойство от участия в фильтрации - необходимо указать null в качестве значения
     *
     * @param params SearchParams - свойства по структуре класса
     * @return Iterable<MedCertBirth> - список найденных свидетельств
     */
    public Iterable<MedCertBirth> getMedCertBirth(SearchParams params) {

        ArrayList<SearchElement> paramsAL = params.toArrayList();

        Specification<MedCertBirth> specification  = Specification.where(whereAndStart());

        for (SearchElement param:paramsAL) {
            specification = specification.and(addSearchElement(param));
        }

        return medCertBirthRepository.findAll(specification);
    }


}
