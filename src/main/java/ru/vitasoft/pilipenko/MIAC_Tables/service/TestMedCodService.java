package ru.vitasoft.pilipenko.MIAC_Tables.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.model.ComingData;
import ru.vitasoft.pilipenko.MIAC_Tables.model.TestMedCod;
import ru.vitasoft.pilipenko.MIAC_Tables.model.TestMedCodRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestMedCodService {

   // private final TestMedCodRepository testMedCodRepository;
    @Autowired
   TestMedCodRepository testMedCodRepository;

//    public TestMedCodService(){}
   // @Autowired
//    public TestMedCodService(TestMedCodRepository testMedCodRepository) {
//        this.testMedCodRepository = testMedCodRepository;
//    }



    public void deleteAllFromCurrentTable(){
        testMedCodRepository.deleteAll();
        System.out.println("delete all from TestMedCod");
    }

    public void addToCurrentTable(ComingData comingData){
        String certificateKey = "000001";
        String lineCoded = "1";
        List<String> codes = new ArrayList<>();
        String a = comingData.getMkb10().getA();
        String b = comingData.getMkb10().getB();
        String c = comingData.getMkb10().getC();
//        String d = comingData.getMkb10().getD();
        codes.add(a);
        codes.add(b);
        codes.add(c);
//        codes.add(d);

        for (int i = 0; i < codes.size(); i++) {

            TestMedCod testMedCod = new TestMedCod();
            testMedCod.setCertificateKey(certificateKey);
            testMedCod.setLineNb(i);
//            testMedCod.setTextLine(" ");
//            testMedCod.setIntervalLine(" ");
//            testMedCod.setCodeOnly(" ");
            testMedCod.setCodeLine(codes.get(i));
            testMedCod.setLineCoded(lineCoded);
            testMedCodRepository.save(testMedCod);
        }
        System.out.println("info add to DB");

    }

    public void createLine(){
        List<TestMedCod> mclist = new ArrayList<>();
        mclist = testMedCodRepository.findAll();

        TestMedCod testMedCod = new TestMedCod();
        testMedCod.setCertificateKey("000001");
        testMedCod.setCodeLine("shit");
        testMedCod.setLineCoded("1");
        testMedCodRepository.save(testMedCod);

    }

}
