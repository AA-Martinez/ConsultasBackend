package com.nash.Medication;

import com.nash.Allergy.Allergy;
import com.nash.ObjectResponse.ObjectResponse;
import com.nash.Substance.Substance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medication")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping
    ObjectResponse findAll() {
        ObjectResponse res = new ObjectResponse();
        try {
            res.setData(medicationService.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PostMapping
    ObjectResponse save(@RequestBody Medication medication) {
        ObjectResponse res = new ObjectResponse();
        try {
            medicationService.save(medication);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
