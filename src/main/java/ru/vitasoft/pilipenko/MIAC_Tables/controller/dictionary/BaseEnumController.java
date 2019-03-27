
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
import ru.vitasoft.pilipenko.MIAC_Tables.services.baseEnum.BaseEnumService;

@RestController
@RequestMapping("/baseEnum")
public class BaseEnumController {

    @Autowired
    public BaseEnumService dictionarySvc;

    @GetMapping(value = "/addressType")
    public Iterable<AddressType> birthTypeFindAll() {
        return dictionarySvc.findAddressType();
    }

    @GetMapping(value = "/birthLocation")
    public Iterable<BirthLocation> birthLocationFindAll() {
        return dictionarySvc.findBirthLocation();
    }

    @GetMapping(value = "/birthRelatedDeathMoment")
    public Iterable<BirthRelatedDeathMoment> birthRelatedDeathMomentFindAll() {
        return dictionarySvc.findBirthRelatedDeathMoment();
    }

    @GetMapping(value = "/certStatus")
    public Iterable<CertStatus> certStatusFindAll() {
        return dictionarySvc.findCertStatus();
    }

    @GetMapping(value = "/certType")
    public Iterable<CertType> certTypeFindAll() {
        return dictionarySvc.findCertType();
    }

    @GetMapping(value = "/deathPregnantState")
    public Iterable<DeathPregnantState> deathPregnantStateFindAll() {
        return dictionarySvc.findDeathPregnantState();
    }

    @GetMapping(value = "/deathRoadAccidentState")
    public Iterable<DeathRoadAccidentState> deathRoadAccidentStateFindAll() {
        return dictionarySvc.findDeathRoadAccidentState();
    }

    @GetMapping(value = "/diagnType")
    public Iterable<DiagnType> diagnTypeFindAll() {
        return dictionarySvc.findDiagnType();
    }

    @GetMapping(value = "/eduLevel")
    public Iterable<EduLevel> eduLevelFindAll() {
        return dictionarySvc.findEduLevel();
    }

    @GetMapping(value = "/emplState")
    public Iterable<EmplState> emplStateFindAll() {
        return dictionarySvc.findEmplState();
    }

    @GetMapping(value = "/familyStatus")
    public Iterable<FamilyStatus> familyStatusFindAll() {
        return dictionarySvc.findFamilyStatus();
    }

    @GetMapping(value = "/fertility")
    public Iterable<Fertility> fertilityFindAll() {
        return dictionarySvc.findFertility();
    }

    @GetMapping(value = "/fetusType")
    public Iterable<FetusType> fetusTypeFindAll() {
        return dictionarySvc.findFetusType();
    }

    @GetMapping(value = "/gender")
    public Iterable<Gender> genderFindAll() {
        return dictionarySvc.findGender();
    }

    @GetMapping(value = "/genderChild")
    public Iterable<GenderChild> genderChildFindAll() {
        return dictionarySvc.findGenderChild();
    }

    @GetMapping(value = "/locality")
    public Iterable<Locality> localityFindAll() {
        return dictionarySvc.findLocality();
    }


    @GetMapping(value = "/relationshipType")
    public Iterable<RelationshipType> relationshipTypeFindAll() {
        return dictionarySvc.findRelationshipType();
    }

    @GetMapping(value = "/accoucheurType/birth")
    public Iterable<AccoucheurTypeB> accoucheurTypeBFindAll() {
        return dictionarySvc.findAccoucheurTypeB();
    }

    @GetMapping(value = "/deathAccident/death")
    public Iterable<DeathAccidentD> deathAccidentDFindAll() {
        return dictionarySvc.findDeathAccidentD();
    }

    @GetMapping(value = "/deathLocation/death")
    public Iterable<DeathLocationD> deathLocationDFindAll() {
        return dictionarySvc.findDeathLocationD();
    }

    @GetMapping(value = "/recordedDeathBased/death")
    public Iterable<RecordedDeathBasedD> recordedDeathBasedDFindAll() {
        return dictionarySvc.findRecordedDeathBasedD();
    }

    @GetMapping(value = "/recordedDeathEmplType/death")
    public Iterable<RecordedDeathEmplTypeD> recordedDeathEmplTypeDFindAll() {
        return dictionarySvc.findRecordedDeathEmplTypeD();
    }

    @GetMapping(value = "/accoucheurType/perinatalDeath")
    public Iterable<AccoucheurTypeP> accoucheurTypePFindAll() {
        return dictionarySvc.findAccoucheurTypeP();
    }

    @GetMapping(value = "/deathAccident/perinatalDeath")
    public Iterable<DeathAccidentP> deathAccidentPFindAll() {
        return dictionarySvc.findDeathAccidentP();
    }

    @GetMapping(value = "/recordedDeathBased/perinatalDeath")
    public Iterable<RecordedDeathBasedP> recordedDeathBasedPFindAll() {
        return dictionarySvc.findRecordedDeathBasedP();
    }

    @GetMapping(value = "/recordedDeathEmplType/perinatalDeath")
    public Iterable<RecordedDeathEmplTypeP> recordedDeathEmplTypePFindAll() {
        return dictionarySvc.findRecordedDeathEmplTypeP();
    }

}
