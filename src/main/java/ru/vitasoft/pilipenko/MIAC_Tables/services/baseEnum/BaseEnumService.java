package ru.vitasoft.pilipenko.MIAC_Tables.services.baseEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertBirth.AccoucheurTypeB;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathAccidentD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.DeathLocationD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.RecordedDeathBasedD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertDeath.RecordedDeathEmplTypeD;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.baseEnum.medCertPerinatalDeath.*;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.*;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.medCertBirth.AccoucheurTypeBRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.medCertDeath.DeathAccidentDRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.medCertDeath.DeathLocationDRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.medCertDeath.RecordedDeathBasedDRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.medCertDeath.RecordedDeathEmplTypeDRepository;
import ru.vitasoft.pilipenko.MIAC_Tables.repository.baseEnum.medCertPerinatalDeath.*;

@Service
public class BaseEnumService {
    @Autowired
    AccoucheurTypeBRepository accoucheurTypeBRepository;
    public Iterable<AccoucheurTypeB> findAccoucheurTypeB(){
        return accoucheurTypeBRepository.findAll();
    }

    @Autowired
    DeathAccidentDRepository deathAccidentDRepository;
    public Iterable<DeathAccidentD> findDeathAccidentD(){
        return deathAccidentDRepository.findAll();
    }

    @Autowired
    DeathLocationDRepository deathLocationDRepository;
    public Iterable<DeathLocationD> findDeathLocationD(){
        return deathLocationDRepository.findAll();
    }

    @Autowired
    RecordedDeathBasedDRepository recordedDeathBasedDRepository;
    public Iterable<RecordedDeathBasedD> findRecordedDeathBasedD(){
        return recordedDeathBasedDRepository.findAll();
    }

    @Autowired
    RecordedDeathEmplTypeDRepository recordedDeathEmplTypeDRepository;
    public Iterable<RecordedDeathEmplTypeD> findRecordedDeathEmplTypeD(){
        return recordedDeathEmplTypeDRepository.findAll();
    }

    @Autowired
    AccoucheurTypePRepository accoucheurTypePRepository;
    public Iterable<AccoucheurTypeP> findAccoucheurTypeP(){
        return accoucheurTypePRepository.findAll();
    }

    @Autowired
    DeathAccidentPRepository deathAccidentPRepository;
    public Iterable<DeathAccidentP> findDeathAccidentP(){
        return deathAccidentPRepository.findAll();
    }

    @Autowired
    DeathLocationPRepository deathLocationPRepository;
    public Iterable<DeathLocationP> findDeathLocationP(){
        return deathLocationPRepository.findAll();
    }

    @Autowired
    RecordedDeathBasedPRepository recordedDeathBasedPRepository;
    public Iterable<RecordedDeathBasedP> findRecordedDeathBasedP(){
        return recordedDeathBasedPRepository.findAll();
    }

    @Autowired
    RecordedDeathEmplTypePRepository recordedDeathEmplTypePRepository;
    public Iterable<RecordedDeathEmplTypeP> findRecordedDeathEmplTypeP(){
        return recordedDeathEmplTypePRepository.findAll();
    }

    @Autowired
    AddressTypeRepository addressTypeRepository;
    public Iterable<AddressType> findAddressType(){
        return addressTypeRepository.findAll();
    }

    @Autowired
    BirthLocationRepository birthLocationRepository;
    public Iterable<BirthLocation> findBirthLocation(){
        return birthLocationRepository.findAll();
    }

    @Autowired
    BirthRelatedDeathMomentRepository birthRelatedDeathMomentRepository;
    public Iterable<BirthRelatedDeathMoment> findBirthRelatedDeathMoment(){
        return birthRelatedDeathMomentRepository.findAll();
    }

    @Autowired
    CertStatusRepository certStatusRepository;
    public Iterable<CertStatus> findCertStatus(){
        return certStatusRepository.findAll();
    }

    @Autowired
    CertTypeRepository certTypeRepository;
    public Iterable<CertType> findCertType(){
        return certTypeRepository.findAll();
    }

    @Autowired
    DeathPregnantStateRepository deathPregnantStateRepository;
    public Iterable<DeathPregnantState> findDeathPregnantState(){
        return deathPregnantStateRepository.findAll();
    }

    @Autowired
    DeathRoadAccidentStateRepository deathRoadAccidentStateRepository;
    public Iterable<DeathRoadAccidentState> findDeathRoadAccidentState(){
        return deathRoadAccidentStateRepository.findAll();
    }

    @Autowired
    DiagnTypeRepository diagnTypeRepository;
    public Iterable<DiagnType> findDiagnType(){
        return diagnTypeRepository.findAll();
    }

    @Autowired
    EduLevelRepository eduLevelRepository;
    public Iterable<EduLevel> findEduLevel(){
        return eduLevelRepository.findAll();
    }

    @Autowired
    EmplStateRepository emplStateRepository;
    public Iterable<EmplState> findEmplState(){
        return emplStateRepository.findAll();
    }

    @Autowired
    FamilyStatusRepository familyStatusRepository;
    public Iterable<FamilyStatus> findFamilyStatus(){
        return familyStatusRepository.findAll();
    }

    @Autowired
    FertilityRepository fertilityRepository;
    public Iterable<Fertility> findFertility(){
        return fertilityRepository.findAll();
    }

    @Autowired
    FetusTypeRepository fetusTypeRepository;
    public Iterable<FetusType> findFetusType(){
        return fetusTypeRepository.findAll();
    }

    @Autowired
    GenderChildRepository genderChildRepository;
    public Iterable<GenderChild> findGenderChild(){
        return genderChildRepository.findAll();
    }

    @Autowired
    GenderRepository genderRepository;
    public Iterable<Gender> findGender(){
        return genderRepository.findAll();
    }

    @Autowired
    LocalityRepository localityRepository;
    public Iterable<Locality> findLocality(){
        return localityRepository.findAll();
    }

    @Autowired
    RelationshipTypeRepository relationshipTypeRepository;
    public Iterable<RelationshipType> findRelationshipType(){
        return relationshipTypeRepository.findAll();
    }
}
