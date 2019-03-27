
package ru.vitasoft.pilipenko.MIAC_Tables.controller.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertBirth.AccoucheurTypeB;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathAccidentD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathLocationD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.RecordedDeathBasedD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.RecordedDeathEmplTypeD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.AccoucheurTypeP;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.DeathAccidentP;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.RecordedDeathBasedP;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.RecordedDeathEmplTypeP;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.IdentityDoc;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.MKB10;
import ru.vitasoft.pilipenko.MIAC_Tables.services.baseEnum.BaseEnumService;
import ru.vitasoft.pilipenko.MIAC_Tables.services.dictionary.DictionaryService;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    public DictionaryService dictionarySvc;

    @GetMapping(value = "/identityDoc")
    public Iterable<IdentityDoc> IdentityDocAll() {
        return dictionarySvc.findIdentityDoc();
    }

    @GetMapping(value = "/birthLocation")
    public Iterable<MKB10> mkb10FindAll() {
        return dictionarySvc.findMKB10();
    }

}
