package ru.vitasoft.pilipenko.MIAC_Tables.services.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.FIAS.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users.ExternalUsers;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users.MiacUsers;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.dictionary.Users.Users;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.*;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.FIAS.*;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.Users.ExternalUsersRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.Users.MiacUsersRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.dictionary.Users.UsersRepository;


@Service
public class DictionarySvc {

//region BaseEnums

    @Autowired
    BirthTypeRepository birthTypeRepository;
    public Iterable<BirthType> birthTypeFindAll() {
        return birthTypeRepository.findAll();
    }

    @Autowired
    CertTypeRepository certTypeRepository;
    public Iterable<CertType> certTypeFindAll() {
        return certTypeRepository.findAll();
    }

    @Autowired
    ChildBirthOccuredRepository childBirthOccuredRepository;
    public Iterable<ChildBirthOccured> childBirthOccuredFindAll() {
        return childBirthOccuredRepository.findAll();
    }

    @Autowired
    DeathOccuredFromRepository deathOccuredFromRepository;
    public Iterable<DeathOccuredFrom> deathOccuredFromFindAll() {
        return deathOccuredFromRepository.findAll();
    }

    @Autowired
    DeathOccuredInRepository deathOccuredInRepository;
    public Iterable<DeathOccuredIn> deathOccuredInFindAll() {
        return deathOccuredInRepository.findAll();
    }

    @Autowired
    DeathReasonsEstablishedByRepository deathReasonsEstablishedByRepository;
    public Iterable<DeathReasonsEstablishedBy> DeathReasonsEstablishedByFindAll() {
        return deathReasonsEstablishedByRepository.findAll();
    }

    @Autowired
    DeathReasonsEstablishedOnBasisOfRepository deathReasonsEstablishedOnBasisOfRepository;
    public Iterable<DeathReasonsEstablishedOnBasisOf> deathReasonsEstablishedOnBasisOfFindAll() {
        return deathReasonsEstablishedOnBasisOfRepository.findAll();
    }

    @Autowired
    DeathResultedWhenRepository deathResultedWhenRepositoryRepository;
    public Iterable<DeathResultedWhen> deathResultedWhenRepositoryFindAll() {
        return deathResultedWhenRepositoryRepository.findAll();
    }

    @Autowired
    FetusRepository fetusRepository;
    public Iterable<Fetus> fetusFindAll() {
        return fetusRepository.findAll();
    }

    @Autowired
    IssuedByMedicalAssistantRepository issuedByMedicalAssistantRepository;
    public Iterable<IssuedByMedicalAssistant> issuedByMedicalAssistantFindAll() {
        return issuedByMedicalAssistantRepository.findAll();
    }

    @Autowired
    ReasonsForDeathEstablishingRepository reasonsForDeathEstablishingRepository;
    public Iterable<ReasonsForDeathEstablishing> reasonsForDeathEstablishingFindAll() {
        return reasonsForDeathEstablishingRepository.findAll();
    }

    @Autowired
    RelationshipToChildRepository relationshipToChildRepository;
    public Iterable<RelationshipToChild> relationshipToChildFindAll() {
        return relationshipToChildRepository.findAll();
    }

    @Autowired
    SexRepository sexRepository;
    public Iterable<Sex> sexFindAll() {
        return sexRepository.findAll();
    }

    @Autowired
    WasBornFetusRepository wasBornFetusRepository;
    public Iterable<WasBornFetus> wasBornFetusFindAll() {
        return wasBornFetusRepository.findAll();
    }

//endregion

//region Dictionaries

    //region FIAS
    @Autowired
    AddressesRepository addressesRepository;
    public Iterable<Addresses> addressesFindAll() {
        return addressesRepository.findAll();
    }

    @Autowired
    CitiesRepository citiesRepository;
    public Iterable<Cities> citiesFindAll() {
        return citiesRepository.findAll();
    }

    @Autowired
    CountriesRepository countriesRepository;
    public Iterable<Countries> countriesFindAll() {
        return countriesRepository.findAll();
    }

    @Autowired
    DistrictsRepository districtsRepository;
    public Iterable<Districts> districtsFindAll() {
        return districtsRepository.findAll();
    }

    @Autowired
    LocalitiesRepository localitiesRepository;
    public Iterable<Localities> localitiesFindAll() {
        return localitiesRepository.findAll();
    }

    @Autowired
    SubjectsOfFederationRepository subjectsOfFederationRepository;
    public Iterable<SubjectsOfFederation> subjectsOfFederationFindAll() {
        return subjectsOfFederationRepository.findAll();
    }
    //endregion

    //region Users
    @Autowired
    ExternalUsersRepository externalUsersRepository;
    public Iterable<ExternalUsers> externalUsersFindAll() {
        return externalUsersRepository.findAll();
    }

    @Autowired
    MiacUsersRepository miacUsersRepository;
    public Iterable<MiacUsers> miacUsersFindAll() {
        return miacUsersRepository.findAll();
    }

    @Autowired
    UsersRepository usersRepository;
    public Iterable<Users> UsersFindAll() {
        return usersRepository.findAll();
    }

    //endregion

    @Autowired
    ActRecordsRepository actRecordsRepository;
    public Iterable<ActRecords> actRecordsFindAll() {
        return actRecordsRepository.findAll();
    }

    @Autowired
    CivilRegistryDepartmentsRepository civilRegistryDepartmentsRepository;
    public Iterable<CivilRegistryDepartments> civilRegistryDepartmentsFindAll() {
        return civilRegistryDepartmentsRepository.findAll();
    }

    @Autowired
    DeathReasonsDiagRepository deathReasonsDiagRepository;
    public Iterable<DeathReasonsDiag> deathReasonsDiagFindAll() {
        return deathReasonsDiagRepository.findAll();
    }

    @Autowired
    DeathReasonsRepository deathReasonsRepository;
    public Iterable<DeathReasons> deathReasonsFindAll() {
        return deathReasonsRepository.findAll();
    }

    @Autowired
    DocTypeRepository docTypeRepository;
    public Iterable<DocType> docTypeFindAll() {
        return docTypeRepository.findAll();
    }

    @Autowired
    EduTypeRepository eduTypeRepository;
    public Iterable<EduType> eduTypeFindAll() {
        return eduTypeRepository.findAll();
    }

    @Autowired
    FamilyStatusRepository familyStatusRepository;
    public Iterable<FamilyStatus> familyStatusFindAll() {
        return familyStatusRepository.findAll();
    }

    @Autowired
    MedicsRepository medicsRepository;
    public Iterable<Medics> medicsFindAll() {
        return medicsRepository.findAll();
    }

    @Autowired
    MedOrgRepository medOrgRepository;
    public Iterable<MedOrg> medOrgFindAll() {
        return medOrgRepository.findAll();
    }

    @Autowired
    MKB10Repository mKB10Repository;
    public Iterable<MKB10> mKB10FindAll() {
        return mKB10Repository.findAll();
    }

    @Autowired
    OccupationRepository occupationRepository;
    public Iterable<Occupation> occupationFindAll() {
        return occupationRepository.findAll();
    }

    @Autowired
    PersonTookBirthRepository personTookBirthRepository;
    public Iterable<PersonTookBirth> personTookBirthFindAll() {
        return personTookBirthRepository.findAll();
    }

    @Autowired
    RecipientRepository recipientRepository;
    public Iterable<Recipient> recipientRepositoryFindAll() {
        return recipientRepository.findAll();
    }

    @Autowired
    SurgeriesRepository surgeriesRepository;
    public Iterable<Surgeries> surgeriesRepositoryFindAll() {
        return surgeriesRepository.findAll();
    }

//endregion

}
