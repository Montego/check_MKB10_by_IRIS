package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.Surgery;
import ru.vitasoft.pilipenko.MIAC_Tables.services.SurgerySvc;

@RestController
@RequestMapping("/rest")
public class SurgeryController {

    private final SurgerySvc surgerySvc;

    @Autowired
    public SurgeryController(SurgerySvc surgerySvc) {
        this.surgerySvc = surgerySvc;
    }

//GET

    @GetMapping("/getEmptySurgery")
    public Surgery getEmptySurgery(){

        return surgerySvc.getEmptySurgery();

    }

//POST

    @PostMapping("/addSurgery")
    public JSONObject addSurgery(@RequestBody Surgery surgery)  {

        return surgerySvc.save(surgery);

    }
}
