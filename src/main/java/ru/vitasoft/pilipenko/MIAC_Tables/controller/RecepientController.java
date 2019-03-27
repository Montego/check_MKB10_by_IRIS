package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Recepient;
import ru.vitasoft.pilipenko.MIAC_Tables.services.RecepientSvc;

@RestController
@RequestMapping("/rest")
public class RecepientController {

    private final RecepientSvc recepientSvc;

    @Autowired
    public RecepientController(RecepientSvc recepientSvc) {
        this.recepientSvc = recepientSvc;
    }

//GET

    @GetMapping("/getEmptyRecepient")
    public Recepient getEmptyRecepient(){

        return recepientSvc.getEmptyRecepient();

    }

//POST

    @PostMapping("/addRecepient")
    public JSONObject addRecepient(@RequestBody Recepient recepient)  {

        return recepientSvc.save(recepient);

    }
}
