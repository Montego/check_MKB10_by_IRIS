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

    private final
    BirthTypeRepository birthTypeRepository;

    @Autowired
    public DictionarySvc(BirthTypeRepository birthTypeRepository, DeathReasonsEstablishedByRepository deathReasonsEstablishedByRepository, ChildBirthOccuredRepository childBirthOccuredRepository, CertTypeRepository certTypeRepository, WasBornFetusRepository wasBornFetusRepository, ActRecordsRepository actRecordsRepository, ExternalUsersRepository externalUsersRepository, MiacUsersRepository miacUsersRepository, DeathOccuredFromRepository deathOccuredFromRepository, CivilRegistryDepartmentsRepository civilRegistryDepartmentsRepository, DeathOccuredInRepository deathOccuredInRepository, FamilyStatusRepository familyStatusRepository, DeathReasonsEstablishedOnBasisOfRepository deathReasonsEstablishedOnBasisOfRepository, DeathResultedWhenRepository deathResultedWhenRepositoryRepository, FetusRepository fetusRepository, IssuedByMedicalAssistantRepository issuedByMedicalAssistantRepository, OccupationRepository occupationRepository, DeathReasonsRepository deathReasonsRepository, ReasonsForDeathEstablishingRepository reasonsForDeathEstablishingRepository, SurgeriesRepository surgeriesRepository, UsersRepository usersRepository, MKB10Repository mKB10Repository, CitiesRepository citiesRepository, SubjectsOfFederationRepository subjectsOfFederationRepository, EduTypeRepository eduTypeRepository, CountriesRepository countriesRepository, SexRepository sexRepository, DocTypeRepository docTypeRepository, MedOrgRepository medOrgRepository, PersonTookBirthRepository personTookBirthRepository, DistrictsRepository districtsRepository, DeathReasonsDiagRepository deathReasonsDiagRepository, AddressesRepository addressesRepository, RelationshipToChildRepository relationshipToChildRepository, MedicsRepository medicsRepository, LocalitiesRepository localitiesRepository, RecipientRepository recipientRepository) {
        this.birthTypeRepository = birthTypeRepository;
        this.deathReasonsEstablishedByRepository = deathReasonsEstablishedByRepository;
        this.childBirthOccuredRepository = childBirthOccuredRepository;
        this.certTypeRepository = certTypeRepository;
        this.wasBornFetusRepository = wasBornFetusRepository;
        this.actRecordsRepository = actRecordsRepository;
        this.externalUsersRepository = externalUsersRepository;
        this.miacUsersRepository = miacUsersRepository;
        this.deathOccuredFromRepository = deathOccuredFromRepository;
        this.civilRegistryDepartmentsRepository = civilRegistryDepartmentsRepository;
        this.deathOccuredInRepository = deathOccuredInRepository;
        this.familyStatusRepository = familyStatusRepository;
        this.deathReasonsEstablishedOnBasisOfRepository = deathReasonsEstablishedOnBasisOfRepository;
        this.deathResultedWhenRepositoryRepository = deathResultedWhenRepositoryRepository;
        this.fetusRepository = fetusRepository;
        this.issuedByMedicalAssistantRepository = issuedByMedicalAssistantRepository;
        this.occupationRepository = occupationRepository;
        this.deathReasonsRepository = deathReasonsRepository;
        this.reasonsForDeathEstablishingRepository = reasonsForDeathEstablishingRepository;
        this.surgeriesRepository = surgeriesRepository;
        this.usersRepository = usersRepository;
        this.mKB10Repository = mKB10Repository;
        this.citiesRepository = citiesRepository;
        this.subjectsOfFederationRepository = subjectsOfFederationRepository;
        this.eduTypeRepository = eduTypeRepository;
        this.countriesRepository = countriesRepository;
        this.sexRepository = sexRepository;
        this.docTypeRepository = docTypeRepository;
        this.medOrgRepository = medOrgRepository;
        this.personTookBirthRepository = personTookBirthRepository;
        this.districtsRepository = districtsRepository;
        this.deathReasonsDiagRepository = deathReasonsDiagRepository;
        this.addressesRepository = addressesRepository;
        this.relationshipToChildRepository = relationshipToChildRepository;
        this.medicsRepository = medicsRepository;
        this.localitiesRepository = localitiesRepository;
        this.recipientRepository = recipientRepository;
    }

    public Iterable<BirthType> birthTypeFindAll() {
        return birthTypeRepository.findAll();
    }

    private final
    CertTypeRepository certTypeRepository;
    public Iterable<CertType> certTypeFindAll() {
        return certTypeRepository.findAll();
    }

    private final
    ChildBirthOccuredRepository childBirthOccuredRepository;
    public Iterable<ChildBirthOccured> childBirthOccuredFindAll() {
        return childBirthOccuredRepository.findAll();
    }

    private final
    DeathOccuredFromRepository deathOccuredFromRepository;
    public Iterable<DeathOccuredFrom> deathOccuredFromFindAll() {
        return deathOccuredFromRepository.findAll();
    }

    private final
    DeathOccuredInRepository deathOccuredInRepository;
    public Iterable<DeathOccuredIn> deathOccuredInFindAll() {
        return deathOccuredInRepository.findAll();
    }

    private final
    DeathReasonsEstablishedByRepository deathReasonsEstablishedByRepository;
    public Iterable<DeathReasonsEstablishedBy> DeathReasonsEstablishedByFindAll() {
        return deathReasonsEstablishedByRepository.findAll();
    }

    private final
    DeathReasonsEstablishedOnBasisOfRepository deathReasonsEstablishedOnBasisOfRepository;
    public Iterable<DeathReasonsEstablishedOnBasisOf> deathReasonsEstablishedOnBasisOfFindAll() {
        return deathReasonsEstablishedOnBasisOfRepository.findAll();
    }

    private final
    DeathResultedWhenRepository deathResultedWhenRepositoryRepository;
    public Iterable<DeathResultedWhen> deathResultedWhenRepositoryFindAll() {
        return deathResultedWhenRepositoryRepository.findAll();
    }

    private final
    FetusRepository fetusRepository;
    public Iterable<Fetus> fetusFindAll() {
        return fetusRepository.findAll();
    }

    private final
    IssuedByMedicalAssistantRepository issuedByMedicalAssistantRepository;
    public Iterable<IssuedByMedicalAssistant> issuedByMedicalAssistantFindAll() {
        return issuedByMedicalAssistantRepository.findAll();
    }

    private final
    ReasonsForDeathEstablishingRepository reasonsForDeathEstablishingRepository;
    public Iterable<ReasonsForDeathEstablishing> reasonsForDeathEstablishingFindAll() {
        return reasonsForDeathEstablishingRepository.findAll();
    }

    private final
    RelationshipToChildRepository relationshipToChildRepository;
    public Iterable<RelationshipToChild> relationshipToChildFindAll() {
        return relationshipToChildRepository.findAll();
    }

    private final
    SexRepository sexRepository;
    public Iterable<Sex> sexFindAll() {
        return sexRepository.findAll();
    }

    private final
    WasBornFetusRepository wasBornFetusRepository;
    public Iterable<WasBornFetus> wasBornFetusFindAll() {
        return wasBornFetusRepository.findAll();
    }

//endregion

//region Dictionaries

    //region FIAS
    private final
    AddressesRepository addressesRepository;
    public Iterable<Addresses> addressesFindAll() {
        return addressesRepository.findAll();
    }

    private final
    CitiesRepository citiesRepository;
    public Iterable<Cities> citiesFindAll() {
        return citiesRepository.findAll();
    }

    private final
    CountriesRepository countriesRepository;
    public Iterable<Countries> countriesFindAll() {
        return countriesRepository.findAll();
    }

    private final
    DistrictsRepository districtsRepository;
    public Iterable<Districts> districtsFindAll() {
        return districtsRepository.findAll();
    }

    private final
    LocalitiesRepository localitiesRepository;
    public Iterable<Localities> localitiesFindAll() {
        return localitiesRepository.findAll();
    }

    private final
    SubjectsOfFederationRepository subjectsOfFederationRepository;
    public Iterable<SubjectsOfFederation> subjectsOfFederationFindAll() {
        return subjectsOfFederationRepository.findAll();
    }
    //endregion

    //region Users
    private final
    ExternalUsersRepository externalUsersRepository;
    public Iterable<ExternalUsers> externalUsersFindAll() {
        return externalUsersRepository.findAll();
    }

    private final
    MiacUsersRepository miacUsersRepository;
    public Iterable<MiacUsers> miacUsersFindAll() {
        return miacUsersRepository.findAll();
    }

    private final
    UsersRepository usersRepository;
    public Iterable<Users> UsersFindAll() {
        return usersRepository.findAll();
    }

    //endregion

    private final
    ActRecordsRepository actRecordsRepository;
    public Iterable<ActRecords> actRecordsFindAll() {
        return actRecordsRepository.findAll();
    }

    private final
    CivilRegistryDepartmentsRepository civilRegistryDepartmentsRepository;
    public Iterable<CivilRegistryDepartments> civilRegistryDepartmentsFindAll() {
        return civilRegistryDepartmentsRepository.findAll();
    }

    private final
    DeathReasonsDiagRepository deathReasonsDiagRepository;
    public Iterable<DeathReasonsDiag> deathReasonsDiagFindAll() {
        return deathReasonsDiagRepository.findAll();
    }

    private final
    DeathReasonsRepository deathReasonsRepository;
    public Iterable<DeathReasons> deathReasonsFindAll() {
        return deathReasonsRepository.findAll();
    }

    private final
    DocTypeRepository docTypeRepository;
    public Iterable<DocType> docTypeFindAll() {
        return docTypeRepository.findAll();
    }

    private final
    EduTypeRepository eduTypeRepository;
    public Iterable<EduType> eduTypeFindAll() {
        return eduTypeRepository.findAll();
    }

    private final
    FamilyStatusRepository familyStatusRepository;
    public Iterable<FamilyStatus> familyStatusFindAll() {
        return familyStatusRepository.findAll();
    }

    private final
    MedicsRepository medicsRepository;
    public Iterable<Medics> medicsFindAll() {
        return medicsRepository.findAll();
    }

    private final
    MedOrgRepository medOrgRepository;
    public Iterable<MedOrg> medOrgFindAll() {
        return medOrgRepository.findAll();
    }

    private final
    MKB10Repository mKB10Repository;
    public Iterable<MKB10> mKB10FindAll() {
        return mKB10Repository.findAll();
    }

    private final
    OccupationRepository occupationRepository;
    public Iterable<Occupation> occupationFindAll() {
        return occupationRepository.findAll();
    }

    private final
    PersonTookBirthRepository personTookBirthRepository;
    public Iterable<PersonTookBirth> personTookBirthFindAll() {
        return personTookBirthRepository.findAll();
    }

    private final
    RecipientRepository recipientRepository;
    public Iterable<Recipient> recipientRepositoryFindAll() {
        return recipientRepository.findAll();
    }

    private final
    SurgeriesRepository surgeriesRepository;
    public Iterable<Surgeries> surgeriesRepositoryFindAll() {
        return surgeriesRepository.findAll();
    }

//endregion

}
