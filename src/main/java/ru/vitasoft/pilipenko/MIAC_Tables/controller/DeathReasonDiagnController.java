package ru.vitasoft.pilipenko.MIAC_Tables.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.DeathReasonDiagn;
import ru.vitasoft.pilipenko.MIAC_Tables.services.DeathReasonDiagnSvc;

@RestController
@RequestMapping("/rest")
public class DeathReasonDiagnController {

    private final DeathReasonDiagnSvc deathReasonDiagnSvc;

    @Autowired
    public DeathReasonDiagnController(DeathReasonDiagnSvc deathReasonDiagnSvc) {
        this.deathReasonDiagnSvc = deathReasonDiagnSvc;
    }

//GET

    @GetMapping("/getEmptyDeathReasonDiagn")
    public DeathReasonDiagn getEmptyDeathReason(){

        return deathReasonDiagnSvc.getEmptyDeathReasonDiagnSvc();

    }

//POST

    @PostMapping("/addDeathReasonDiagn")
    public JSONObject addAddress(@RequestBody DeathReasonDiagn deathReasonDiagn)  {

        return deathReasonDiagnSvc.save(deathReasonDiagn);

    }
}
