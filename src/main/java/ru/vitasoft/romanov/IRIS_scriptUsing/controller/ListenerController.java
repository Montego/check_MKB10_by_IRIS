package ru.vitasoft.romanov.IRIS_scriptUsing.controller;

import org.springframework.web.bind.annotation.*;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.Answer;
import ru.vitasoft.romanov.IRIS_scriptUsing.model.ComingData;
import ru.vitasoft.romanov.IRIS_scriptUsing.service.ListenerService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


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

    @PostMapping("/readLog")
    public Answer readLogs(@RequestBody ComingData comingData) throws IOException {
        return listenerService.readFile(comingData);
    }


    @GetMapping("/delLog")
    public void delLogs() {
        listenerService.deleteLog();
    }

    @GetMapping("/alive")
    public String areYouAlive() {
        return "Alive!";
    }

    @PostMapping("/send")
    public Answer send(@RequestBody ComingData comingData) throws IOException, InterruptedException {
        listenerService.deleteLog();
        listenerService.deleteAllFromCurrentTable();
        listenerService.addToCurrentTable(comingData);
        listenerService.startScript();
        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < 5; i++) {
            if (!listenerService.isFileExist()) {
                TimeUnit.SECONDS.sleep(1);
            } else {
                break;
            }
        }

        Answer answer = listenerService.readFile(comingData);
        listenerService.closeScript();

        return answer;
    }
}
