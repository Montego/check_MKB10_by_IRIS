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

    @GetMapping("/del")
    public void del() {
        listenerService.deleteAllFromCurrentTable();
    }

    @GetMapping("/startScript")
    public void startScripting() {
        listenerService.startScript();
    }

    @GetMapping("/closeScript")
    public void closeScripting() {
        listenerService.closeScript();
    }

    @GetMapping("/delLog")
    public void delLogs() {
        listenerService.deleteLog();
    }
    @GetMapping("/alive")
    public String areYouAlive(){
        return listenerService.areYouAlive();
    }

    @PostMapping("/send")
    public Answer send(@RequestBody ComingData comingData) throws IOException, InterruptedException {
//        listenerService.deleteLog();
//        testMedCodService.deleteAllFromCurrentTable();

//        listenerService.deleteFile();
        listenerService.deleteAllFromCurrentTable();
        System.out.println("delete DB from controller");
//        testMedCodService.addToCurrentTable(comingData);
        listenerService.addToCurrentTable(comingData);
        System.out.println("add to DB from controller");
        listenerService.startScript();
        System.out.println("start script from controller");
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i <3 ; i++) {
            if (!listenerService.isFileExist()){
                TimeUnit.SECONDS.sleep(2);
            }else{
                break;
            }
        }

        //for create Log table
        Answer answer;
        answer = listenerService.readFile(comingData);
//        answer = listenerService.doMagicPlease(comingData);
//        listenerService.saveAllInfoAboutWorking(comingData,answer);
        listenerService.closeScript();

        return answer;
    }
}
