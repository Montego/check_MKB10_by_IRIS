package ru.vitasoft.romanov.IRIS_scriptUsing.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.Answer;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.ComingData;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.TestMedCod;
import ru.vitasoft.romanov.IRIS_scriptUsing.repository.TestMedCodRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class ListenerService {
    private TestMedCodRepository testMedCodRepository;

    public ListenerService(TestMedCodRepository testMedCodRepository) {
        this.testMedCodRepository = testMedCodRepository;
    }

    private String directory = "C:/Program Files (x86)/Iris5.6.0/";
    private String nameIrisScript = "autoit_iris-2.exe";
    private String url = directory + nameIrisScript;
    private String nowDay = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    private String nameReadingTxt = "Test" + nowDay + "IrisBatch.log";
    private File file = new File(directory + nameReadingTxt);
    private Answer answer = new Answer();

    private ProcessBuilder builder = new ProcessBuilder(url);
    private Process process;


    public void startScript() {
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


    public boolean isFileExist() {
        return file.exists();
    }


    public Answer readFile(ComingData comingData) throws IOException {
        answer.setId(comingData.getId());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder s = new StringBuilder();
        while ((st = br.readLine()) != null) {
            s.append(st.replaceAll("[\u0000-\u001f &\ufffd]", ""));
            String r = s.toString();
            r = StringUtils.substringBetween(r, "Start", "UC");
            answer.setStatus("checked");
            answer.setTextAnswer(r);
        }
        br.close();

        return answer;
    }


    public void deleteAllFromCurrentTable() {
        testMedCodRepository.deleteAll();
    }

    public void addToCurrentTable(ComingData comingData) {
        String certificateKey = "000001";
        String lineCoded = "1";
        List<String> codes = new ArrayList<>();
        codes.add(comingData.getMkb10().getA());
        codes.add(comingData.getMkb10().getB());
        codes.add(comingData.getMkb10().getC());
        codes.add(comingData.getMkb10().getD());

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

        if (testMedCodRepository.count() == 0) {
            answer.setStatus("codes didn't come");
            System.out.println("codes didn't come");
        } else {
            answer.setStatus("codes came successfully");
            System.out.println("codes came successfully");
        }
    }

    public void deleteLog() {
        if (file.delete()) {
            System.out.println(directory + nameReadingTxt + " was delete");
        } else
            System.out.println(directory + nameReadingTxt + " not found for delete");
        file.deleteOnExit();
    }

}
