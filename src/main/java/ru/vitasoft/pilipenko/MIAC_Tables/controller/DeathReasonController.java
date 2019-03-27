package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.DeathReason;
import ru.vitasoft.pilipenko.MIAC_Tables.services.DeathReasonSvc;

@RestController
@RequestMapping("/rest")
public class DeathReasonController {

    private final DeathReasonSvc deathReasonSvc;

    @Autowired
    public DeathReasonController(DeathReasonSvc deathReasonSvc) {
        this.deathReasonSvc = deathReasonSvc;
    }
//GET

    @GetMapping("/getEmptyDeathReason")
    public DeathReason getEmptyDeathReason(){

        return deathReasonSvc.getEmptyDeathReasonSvc();

    }
//POST

    @PostMapping("/addDeathReason")
    public JSONObject addAddress(@RequestBody DeathReason deathReason)  {

        return deathReasonSvc.save(deathReason);

    }
}
