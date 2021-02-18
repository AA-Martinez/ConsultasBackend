package com.nash.Substance;

import com.nash.ObjectResponse.ObjectResponse;
import com.nash.Patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/substance")
public class SubstanceController {

    @Autowired
    private SubstanceService substanceService;

    @GetMapping
    ObjectResponse findAll() {
        ObjectResponse res = new ObjectResponse();
        try {
            res.setData(substanceService.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PostMapping
    ObjectResponse save(@RequestBody Substance substance) {
        ObjectResponse res = new ObjectResponse();
        try {
            substanceService.save(substance);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
