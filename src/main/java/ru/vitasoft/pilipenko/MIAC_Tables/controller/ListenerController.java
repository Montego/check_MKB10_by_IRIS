package ru.vitasoft.pilipenko.MIAC_Tables.controller;

//import com.listenerexe.listener.Service.DBService;


import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.model.Answer;
import ru.vitasoft.pilipenko.MIAC_Tables.model.ComingData;
import ru.vitasoft.pilipenko.MIAC_Tables.service.ListenerService;
import ru.vitasoft.pilipenko.MIAC_Tables.service.TestMedCodService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

//import com.listenerexe.listener.entity.Listener;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    private final ListenerService listenerService;
//    private final DBService dbService;
    private final TestMedCodService testMedCodService;

    public ListenerController(ListenerService listenerService, TestMedCodService testMedCodService) {
        this.listenerService = listenerService;

        this.testMedCodService = testMedCodService;
    }

    @PostMapping("/add")
    public void add(@RequestBody ComingData comingData) {
         testMedCodService.addToCurrentTable(comingData);
//        dbService.addInfoToCurrentTable(s, comingData);
//        dbService.closeConnection(s);
    }


    @GetMapping("/addSomeShit")
    public void createLine(){
        testMedCodService.createLine();
    }
    @GetMapping("/del")
    public void del(){
       testMedCodService.deleteAllFromCurrentTable();
    }

    @GetMapping("/startScript")
    public void startScripting() throws InterruptedException, IOException {
        listenerService.startScript();
    }
    @GetMapping("/closeScript")
    public void closeScripting() throws InterruptedException, IOException {
        listenerService.closeScript();
    }

//    @GetMapping("/readLog")
//    public Answer readLogs() throws IOException {
//        return listenerService.readLog();
//    }
    @GetMapping("/delLog")
    public void delLogs() throws IOException {
        listenerService.deleteLog();
    }

//    @PostMapping("/sendCodes")
//    public Answer save(@RequestBody ComingData comingData)
//            throws SQLException,
//            ClassNotFoundException,
//            IOException, InterruptedException {
//
//        Statement s = dbService.connectionToDBAccess();
//        dbService.deleteAllFromCurrentTable(s);
//        System.out.println("delete DB from controller");
//
//        dbService.addInfoToCurrentTable(s, comingData);
//        System.out.println("add to DB from controller");
//
//        listenerService.startScript();
//        System.out.println("start script from controller");
//        Answer answer = new Answer();
//        boolean isWork = listenerService.scriptIsAlive();
//        while(isWork) {
//            if (listenerService.fileIsExist()) {
//                answer = listenerService.readLog();
//                isWork = false;
//
//            } else {
//                System.out.println("Fuck!");
//                isWork = false;
//            }
//        }
//        listenerService.closeScript();
////        TimeUnit.SECONDS.sleep(3);
//        System.out.println("read log from controller");
//        dbService.deleteAllFromCurrentTable(s);
//
////        listenerService.closeScript();
//        listenerService.deleteLog();
//        dbService.closeConnection(s);
//    return answer;
//    }

    @PostMapping("/send")
    public Answer send(@RequestBody ComingData comingData) throws IOException, InterruptedException {
//        listenerService.deleteLog();
        testMedCodService.deleteAllFromCurrentTable();
        System.out.println("delete DB from controller");
        testMedCodService.addToCurrentTable(comingData);
        System.out.println("add to DB from controller");
        listenerService.startScript();
        System.out.println("start script from controller");
        TimeUnit.SECONDS.sleep(3);
        Answer answer;
        answer=listenerService.readLog();
        if(listenerService.fileIsExist()){
            answer=listenerService.readLog();
            listenerService.closeScript();
        }
        //        TimeUnit.SECONDS.sleep(3);
        testMedCodService.deleteAllFromCurrentTable();
        System.out.println("delete DB from controller after all");
//        listenerService.deleteLog();
        listenerService.closeScript();
        return answer;
    }
}
