package ru.vitasoft.romanov.IRIS_scriptUsing.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.Answer;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.ComingData;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.Log;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.TestMedCod;
import ru.vitasoft.romanov.IRIS_scriptUsing.repository.TestMedCodRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import com.listenerexe.listener.entity.Listener;

@Service
public class ListenerService {
    @Autowired
    TestMedCodRepository testMedCodRepository;
//    @Autowired
//    LogRepository logRepository;

    private String directory = "C:/Program Files (x86)/Iris5.6.0/";
    private String nameIrisScript = "autoit_iris-2.exe";
    private String url = directory + nameIrisScript;
    private String nowDay = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    private String nameReadingTxt = "Test" + nowDay + "IrisBatch.log";
    File file = new File(directory + nameReadingTxt);
    Answer answer = new Answer();

    ProcessBuilder builder = new ProcessBuilder(url);
    Process process;

    //=====================================Script methods==================================================
    public void startScript(){
        {
            try {
                builder.directory(new File(directory));
                process = builder.start();
                System.out.println("process is starting");
                answer.setStatus("pending");
            } catch (IOException e) {
                System.out.println("process was crashed");
            }
        }
    }

    public void closeScript() {
        System.out.println("process destroyed");
        process.destroy();
    }

    //=====================================File methods==================================================

    public boolean isFileExist() {
        return file.exists();
    }

    public Answer readFile(ComingData comingData) throws IOException {
        answer.setId(comingData.getId());
        System.out.println(file.getName());
        System.out.println("Is file for reading exist?: " + file.exists());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        StringBuilder s = new StringBuilder();
        while ((st = br.readLine()) != null) {
            s.append(st.replaceAll("[\u0000-\u001f &\ufffd]", ""));
            System.out.println(st);
            String r = s.toString();
            r = StringUtils.substringBetween(r, "Start", "UC");
            answer.setStatus("checked");
            answer.setTextAnswer(r);
        }
        br.close();
        return answer;
    }
    public void deleteFile(){
        if (file.delete()) {
                System.out.println(directory + nameReadingTxt + " was delete");
            } else
                System.out.println(directory + nameReadingTxt + " not found for delete");
    }


//    public Answer doMagicPlease(ComingData comingData) throws IOException, InterruptedException {
//        answer.setId(comingData.getId());
//        System.out.println(file.getName());
//        System.out.println("Is file for reading exist?: " + file.exists());
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String st;
//
//            StringBuilder s = new StringBuilder();
//            while ((st = br.readLine()) != null) {
//                s.append(st.replaceAll("[\u0000-\u001f &\ufffd]", ""));
//                System.out.println(st);
//                String r = s.toString();
//                r = StringUtils.substringBetween(r, "Start", "UC");
//                answer.setStatus("checked");
//                answer.setTextAnswer(r);
//            }
//            br.close();
//          TimeUnit.SECONDS.sleep(2);
//            if (file.delete()) {
//                System.out.println(directory + nameReadingTxt + " was delete");
//            } else
//                System.out.println(directory + nameReadingTxt + " not found for delete");
//            closeScript();
////        closeScript();
//        return answer;
//    }

    //=====================================DataBase methods==================================================
    public void deleteAllFromCurrentTable() {
        testMedCodRepository.deleteAll();
        System.out.println("delete all from TestMedCod");
    }

    public void addToCurrentTable(ComingData comingData) {
        String certificateKey = "000001";
        String lineCoded = "1";

        List<String> codes = new ArrayList<>();

        String a = comingData.getMkb10().getA();
        String b = comingData.getMkb10().getB();
        String c = comingData.getMkb10().getC();
        String d = comingData.getMkb10().getD();
        codes.add(a);
        codes.add(b);
        codes.add(c);
        codes.add(d);


        for (int i = 0; i < codes.size(); i++) {
            if (codes.get(i) == null) {
                break;
            } else {
                TestMedCod testMedCod = new TestMedCod();
                testMedCod.setCertificateKey(certificateKey);
                testMedCod.setLineNb(i);
                testMedCod.setCodeLine(codes.get(i));
                testMedCod.setLineCoded(lineCoded);
                testMedCodRepository.save(testMedCod);
            }
        }

        System.out.println("info add to DB");
        if (testMedCodRepository.count() == 0) {
            answer.setStatus("codes didn't come");
            System.out.println("codes didn't come");
        } else {
            answer.setStatus("codes came successfully");
            System.out.println("codes came successfully");
        }
    }

    //=====================================Test methods==================================================
    public void deleteLog() {
        if (file.delete()) {
            System.out.println(directory + nameReadingTxt + " was delete");
        } else
            System.out.println(directory + nameReadingTxt + " not found for delete");
        file.deleteOnExit();
    }

    public void saveAllInfoAboutWorking(ComingData comingData, Answer answer) {
        String certificateKey = "000001";
        Log log = new Log();
        LocalDate today = LocalDate.now();
        log.setDateTime(today);
        log.setCertificateKey(certificateKey);
        log.setCodeOne(comingData.getMkb10().getA());
        log.setCodeTwo(comingData.getMkb10().getB());
        log.setCodeThree(comingData.getMkb10().getC());
        log.setCodeFour(comingData.getMkb10().getD());
        log.setStatus(answer.getStatus());
        log.setLogText(answer.getTextAnswer());
//        logRepository.save(log);
    }

    public String areYouAlive(){
        return new String("I'm alive");
    }
}
