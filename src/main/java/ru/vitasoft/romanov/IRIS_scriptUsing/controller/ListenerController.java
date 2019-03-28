package ru.vitasoft.romanov.IRIS_scriptUsing.controller;

import org.springframework.web.bind.annotation.*;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.Answer;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.ComingData;
import ru.vitasoft.romanov.IRIS_scriptUsing.service.ListenerService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import com.listenerexe.listener.entity.Listener;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    private final ListenerService listenerService;

    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;

    }

    @PostMapping("/add")
    public void add(@RequestBody ComingData comingData) {
         listenerService.addToCurrentTable(comingData);
    }


//    @GetMapping("/del")
//    public void del(){
//       testMedCodService.deleteAllFromCurrentTable();
//    }

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
//        testMedCodService.deleteAllFromCurrentTable();
//        listenerService.deleteAllFromCurrentTable();
        System.out.println("delete DB from controller");
//        testMedCodService.addToCurrentTable(comingData);
        listenerService.addToCurrentTable(comingData);
        System.out.println("add to DB from controller");
        listenerService.startScript();
        System.out.println("start script from controller");
        TimeUnit.SECONDS.sleep(1);
        if(!listenerService.isFileExist()){
            TimeUnit.SECONDS.sleep(2);
        }
        if(!listenerService.isFileExist()){
            TimeUnit.SECONDS.sleep(1);
        }
        if(!listenerService.isFileExist()){
            TimeUnit.SECONDS.sleep(1);
        }
        if(!listenerService.isFileExist()){
            TimeUnit.SECONDS.sleep(1);
        }
        if(!listenerService.isFileExist()){
            TimeUnit.SECONDS.sleep(1);
        }

//        TimeUnit.SECONDS.sleep(3);

//        answer=listenerService.readLog();
//        testMedCodService.deleteAllFromCurrentTable();
        listenerService.deleteAllFromCurrentTable();
        System.out.println("delete DB from controller after all");
        listenerService.closeScript();
        return listenerService.doMagicPlease();
    }
}
