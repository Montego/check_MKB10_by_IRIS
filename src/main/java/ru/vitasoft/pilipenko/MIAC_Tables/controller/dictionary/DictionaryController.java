package ru.vitasoft.pilipenko.MIAC_Tables.controller.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users.*;
import ru.vitasoft.pilipenko.MIAC_Tables.services.dictionary.DictionarySvc;

@RestController
@RequestMapping("/Dictionary")
public class DictionaryController {

    @Autowired
    DictionarySvc dictionarySvc;

//region baseEnum

    @GetMapping(value = "/BirthType")
    public Iterable<BirthType> birthTypeFindAll() {
        return dictionarySvc.birthTypeFindAll();
    }

    @GetMapping(value = "/CertType")
    public Iterable<CertType> certTypeFindAll() {
        return dictionarySvc.certTypeFindAll();
    }

    @GetMapping(value = "/ChildBirthOccured")
    public Iterable<ChildBirthOccured> childBirthOccuredFindAll() {
        return dictionarySvc.childBirthOccuredFindAll();
    }

    @GetMapping(value = "/DeathOccuredFrom")
    public Iterable<DeathOccuredFrom> deathOccuredFromFindAll() {
        return dictionarySvc.deathOccuredFromFindAll();
    }

    @GetMapping(value = "/DeathOccuredIn")
    public Iterable<DeathOccuredIn> deathOccuredInFindAll() {
        return dictionarySvc.deathOccuredInFindAll();
    }

    @GetMapping(value = "/DeathReasonsEstablishedBy")
    public Iterable<DeathReasonsEstablishedBy> DeathReasonsEstablishedByFindAll() {
        return dictionarySvc.DeathReasonsEstablishedByFindAll();
    }

    @GetMapping(value = "/DeathReasonsEstablishedOnBasisOf")
    public Iterable<DeathReasonsEstablishedOnBasisOf> deathReasonsEstablishedOnBasisOfFindAll() {
        return dictionarySvc.deathReasonsEstablishedOnBasisOfFindAll();
    }

    @GetMapping(value = "/DeathResultedWhen")
    public Iterable<DeathResultedWhen> deathResultedWhenRepositoryFindAll() {
        return dictionarySvc.deathResultedWhenRepositoryFindAll();
    }

    @GetMapping(value = "/Fetus")
    public Iterable<Fetus> fetusFindAll() {
        return dictionarySvc.fetusFindAll();
    }

    @GetMapping(value = "/IssuedByMedicalAssistant")
    public Iterable<IssuedByMedicalAssistant> issuedByMedicalAssistantFindAll() {
        return dictionarySvc.issuedByMedicalAssistantFindAll();
    }

    @GetMapping(value = "/ReasonsForDeathEstablishing")
    public Iterable<ReasonsForDeathEstablishing> reasonsForDeathEstablishingFindAll() {
        return dictionarySvc.reasonsForDeathEstablishingFindAll();
    }

    @GetMapping(value = "/RelationshipToChild")
    public Iterable<RelationshipToChild> relationshipToChildFindAll() {
        return dictionarySvc.relationshipToChildFindAll();
    }

    @GetMapping(value = "/Sex")
    public Iterable<Sex> sexFindAll() {
        return dictionarySvc.sexFindAll();
    }

    @GetMapping(value = "/WasBornFetus")
    public Iterable<WasBornFetus> wasBornFetusFindAll() {
        return dictionarySvc.wasBornFetusFindAll();
    }

//endregion


//region Dictionaries

    //region FIAS
    @GetMapping(value = "/Addresses")
    public Iterable<Addresses> addressesFindAll() {
        return dictionarySvc.addressesFindAll();
    }

    @GetMapping(value = "/Cities")
    private Iterable<Cities> citiesFindAll() {
        return dictionarySvc.citiesFindAll();
    }

    @GetMapping(value = "/Countries")
    public Iterable<Countries> countriesFindAll() {
        return dictionarySvc.countriesFindAll();
    }

    @GetMapping(value = "/Districts")
    public Iterable<Districts> districtsFindAll() {
        return dictionarySvc.districtsFindAll();
    }

    @GetMapping(value = "/Localities")
    public Iterable<Localities> localitiesFindAll() {
        return dictionarySvc.localitiesFindAll();
    }

    @GetMapping(value = "/SubjectsOfFederation")
    public Iterable<SubjectsOfFederation> subjectsOfFederationFindAll() {
        return dictionarySvc.subjectsOfFederationFindAll();
    }
    //endregion

    //region Users

    @GetMapping(value = "/ExternalUsers")
    public Iterable<ExternalUsers> externalUsersFindAll() {
        return dictionarySvc.externalUsersFindAll();
    }

    @GetMapping(value = "/MiacUsers")
    public Iterable<MiacUsers> miacUsersFindAll() {
        return dictionarySvc.miacUsersFindAll();
    }

    @GetMapping(value = "/Users")
    public Iterable<Users> UsersFindAll() {
        return dictionarySvc.UsersFindAll();
    }

    //endregion

    @GetMapping(value = "/ActRecords")
    public Iterable<ActRecords> actRecordsFindAll() {
        return dictionarySvc.actRecordsFindAll();
    }

    @GetMapping(value = "/CivilRegistryDepartments")
    public Iterable<CivilRegistryDepartments> civilRegistryDepartmentsFindAll() {
        return dictionarySvc.civilRegistryDepartmentsFindAll();
    }

    @GetMapping(value = "/DeathReasonsDiag")
    public Iterable<DeathReasonsDiag> deathReasonsDiagFindAll() {
        return dictionarySvc.deathReasonsDiagFindAll();
    }

    @GetMapping(value = "/DeathReasons")
    public Iterable<DeathReasons> deathReasonsFindAll() {
        return dictionarySvc.deathReasonsFindAll();
    }

    @GetMapping(value = "/DocType")
    public Iterable<DocType> docTypeFindAll() {
        return dictionarySvc.docTypeFindAll();
    }

    @GetMapping(value = "/EduType")
    public Iterable<EduType> eduTypeFindAll() {
        return dictionarySvc.eduTypeFindAll();
    }

    @GetMapping(value = "/FamilyStatus")
    public Iterable<FamilyStatus> familyStatusFindAll() {
        return dictionarySvc.familyStatusFindAll();
    }

    @GetMapping(value = "/Medics")
    public Iterable<Medics> medicsFindAll() {
        return dictionarySvc.medicsFindAll();
    }

    @GetMapping(value = "/MedOrg")
    public Iterable<MedOrg> medOrgFindAll() {
        return dictionarySvc.medOrgFindAll();
    }

    @GetMapping(value = "/MKB10")
    public Iterable<MKB10> mKB10FindAll() {
        return dictionarySvc.mKB10FindAll();
    }

    @GetMapping(value = "/Occupation")
    public Iterable<Occupation> occupationFindAll() {
        return dictionarySvc.occupationFindAll();
    }

    @GetMapping(value = "/PersonTookBirth")
    public Iterable<PersonTookBirth> personTookBirthFindAll() {
        return dictionarySvc.personTookBirthFindAll();
    }

    @GetMapping(value = "/Recipient")
    public Iterable<Recipient> recipientRepositoryFindAll() {
        return dictionarySvc.recipientRepositoryFindAll();
    }

    @GetMapping(value = "/Surgeries")
    public Iterable<Surgeries> surgeriesRepositoryFindAll() {
        return dictionarySvc.surgeriesRepositoryFindAll();
    }

//endregion

    @GetMapping(value = "/EmptyBirthType")
    public BirthType birthTypeGetEmpty() {
        return dictionarySvc.getEmptyBirthType();
    }


}
