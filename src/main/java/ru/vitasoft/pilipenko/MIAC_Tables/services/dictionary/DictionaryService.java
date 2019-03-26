package ru.vitasoft.pilipenko.MIAC_Tables.services.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.IdentityDoc;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.MKB10;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.IdentityDocRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.MKB10Repository;

@Service
public class DictionaryService {
    @Autowired
    IdentityDocRepository identityDocRepository;
    public Iterable<IdentityDoc> findIdentityDoc(){
        return identityDocRepository.findAll();
    }
    @Autowired
    MKB10Repository mkb10Repository;
    public Iterable<MKB10> findMKB10(){
        return mkb10Repository.findAll();
    }
}
