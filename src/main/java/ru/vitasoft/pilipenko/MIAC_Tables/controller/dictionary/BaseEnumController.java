
package ru.vitasoft.pilipenko.MIAC_Tables.controller.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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


import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/BaseEnum")
public class BaseEnumController {

    @Autowired
    public BaseEnumService dictionarySvc;


////region baseEnum
//
    @GetMapping(value = "/AddressType")
    public Iterable<AddressType> birthTypeFindAll() {
        return dictionarySvc.findAddressType();
    }

    @GetMapping(value = "/BirthLocation")
    public Iterable<BirthLocation> birthLocationFindAll() {
        return dictionarySvc.findBirthLocation();
    }

    @GetMapping(value = "/BirthRelatedDeathMoment")
    public Iterable<BirthRelatedDeathMoment> birthRelatedDeathMomentFindAll() {
        return dictionarySvc.findBirthRelatedDeathMoment();
    }

    @GetMapping(value = "/CertStatus")
    public Iterable<CertStatus> certStatusFindAll() {
        return dictionarySvc.findCertStatus();
    }

    @GetMapping(value = "/CertType")
    public Iterable<CertType> certTypeFindAll() {
        return dictionarySvc.findCertType();
    }

    @GetMapping(value = "/DeathPregnantState")
    public Iterable<DeathPregnantState> deathPregnantStateFindAll() {
        return dictionarySvc.findDeathPregnantState();
    }

    @GetMapping(value = "/DeathRoadAccidentState")
    public Iterable<DeathRoadAccidentState> deathRoadAccidentStateFindAll() {
        return dictionarySvc.findDeathRoadAccidentState();
    }

    @GetMapping(value = "/DiagnType")
    public Iterable<DiagnType> diagnTypeFindAll() {
        return dictionarySvc.findDiagnType();
    }

    @GetMapping(value = "/EduLevel")
    public Iterable<EduLevel> eduLevelFindAll() {
        return dictionarySvc.findEduLevel();
    }

    @GetMapping(value = "/EmplState")
    public Iterable<EmplState> emplStateFindAll() {
        return dictionarySvc.findEmplState();
    }

    @GetMapping(value = "/FamilyStatus")
    public Iterable<FamilyStatus> familyStatusFindAll() {
        return dictionarySvc.findFamilyStatus();
    }

    @GetMapping(value = "/Fertility")
    public Iterable<Fertility> fertilityFindAll() {
        return dictionarySvc.findFertility();
    }

    @GetMapping(value = "/FetusType")
    public Iterable<FetusType> fetusTypeFindAll() {
        return dictionarySvc.findFetusType();
    }

    @GetMapping(value = "/Gender")
    public Iterable<Gender> genderFindAll() {
        return dictionarySvc.findGender();
    }

    @GetMapping(value = "/GenderChild")
    public Iterable<GenderChild> genderChildFindAll() {
        return dictionarySvc.findGenderChild();
    }

    @GetMapping(value = "/Locality")
    public Iterable<Locality> localityFindAll() {
        return dictionarySvc.findLocality();
    }


    @GetMapping(value = "/RelationshipType")
    public Iterable<RelationshipType> relationshipTypeFindAll() {
        return dictionarySvc.findRelationshipType();
    }

    @GetMapping(value = "/AccoucheurTypeB")
    public Iterable<AccoucheurTypeB> accoucheurTypeBFindAll() {
        return dictionarySvc.findAccoucheurTypeB();
    }

    @GetMapping(value = "/DeathAccidentD")
    public Iterable<DeathAccidentD> deathAccidentDFindAll() {
        return dictionarySvc.findDeathAccidentD();
    }

    @GetMapping(value = "/DeathLocationD")
    public Iterable<DeathLocationD> deathLocationDFindAll() {
        return dictionarySvc.findDeathLocationD();
    }

    @GetMapping(value = "/RecordedDeathBasedD")
    public Iterable<RecordedDeathBasedD> recordedDeathBasedDFindAll() {
        return dictionarySvc.findRecordedDeathBasedD();
    }

    @GetMapping(value = "/RecordedDeathEmplTypeD")
    public Iterable<RecordedDeathEmplTypeD> recordedDeathEmplTypeDFindAll() {
        return dictionarySvc.findRecordedDeathEmplTypeD();
    }

    @GetMapping(value = "/AccoucheurTypeP")
    public Iterable<AccoucheurTypeP> accoucheurTypePFindAll() {
        return dictionarySvc.findAccoucheurTypeP();
    }

    @GetMapping(value = "/DeathAccidentP")
    public Iterable<DeathAccidentP> deathAccidentPFindAll() {
        return dictionarySvc.findDeathAccidentP();
    }

    @GetMapping(value = "/RecordedDeathBasedP")
    public Iterable<RecordedDeathBasedP> recordedDeathBasedPFindAll() {
        return dictionarySvc.findRecordedDeathBasedP();
    }

    @GetMapping(value = "/RecordedDeathEmplTypeP")
    public Iterable<RecordedDeathEmplTypeP> recordedDeathEmplTypePFindAll() {
        return dictionarySvc.findRecordedDeathEmplTypeP();
    }

}
