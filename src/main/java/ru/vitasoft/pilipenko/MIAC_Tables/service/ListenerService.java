package ru.vitasoft.pilipenko.MIAC_Tables.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.vitasoft.pilipenko.MIAC_Tables.model.Answer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import com.listenerexe.listener.entity.Listener;

@Service
public class ListenerService {
    private String directory = "C:/Program Files (x86)/Iris5.6.0/";
    private String nameIrisScript = "autoit_iris-2.exe";
    private String url = directory + nameIrisScript;

    private String nowDay = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

    private String nameReadingTxt = "Test" + nowDay + "IrisBatch.log";

    private String nameDBAccess = "Iris-Certificates-V5.5-Y2018S1";

    ProcessBuilder builder = new ProcessBuilder(url);
    Process process;

    public void startScript() throws IOException {
        {
            try {
                builder.directory(new File(directory));
                process = builder.start();

                System.out.println("process is starting");
//                process.destroy();
//                System.out.println("process destroyed");
//                System.out.println("process is alive? :" + process.isAlive());
            } catch (IOException e) {
                System.out.println("process was crashed");
            }
        }
    }

    public void closeScript(){
        System.out.println("process destroyed");
        process.destroy();
    }
    public boolean scriptIsAlive(){
        System.out.println("process is alive? :" + process.isAlive());
        return process.isAlive();
    }

//    Answer answer = new Answer();
    File file = new File(directory + nameReadingTxt);

    public boolean fileIsExist(){
        return file.exists();
    }
    public Answer readLog() throws IOException {
        Answer answer = new Answer();

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
//rule for checking
            answer.setStatus("checked");
            answer.setTextAnswer(r);
        }
        return answer;
    }

    public void deleteLog() {
//        File file = new File(directory + nameReadingTxt);
          if (file.delete()) {
            System.out.println(directory + nameReadingTxt + " was delete");
        } else
            System.out.println(directory + nameReadingTxt + " not found for delete");
        file.deleteOnExit();
    }
    //test method
    public Answer doMagicPlease() throws IOException {
        Answer answer = new Answer();

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
//rule for checking
            answer.setStatus("checked");
            answer.setTextAnswer(r);
        }
        br.close();
        if (file.delete()) {
            System.out.println(directory + nameReadingTxt + " was delete");
        } else
            System.out.println(directory + nameReadingTxt + " not found for delete");
//        closeScript();
        return answer;
    }
}
