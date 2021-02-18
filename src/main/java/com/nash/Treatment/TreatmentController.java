package com.nash.Treatment;

import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/treatment")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @PostMapping
    ObjectResponse save(@RequestBody Treatment treatment) {
        ObjectResponse res = new ObjectResponse();
        try{
            treatmentService.createTreatment(treatment);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
