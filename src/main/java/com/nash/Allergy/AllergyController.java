package com.nash.Allergy;

import com.nash.ObjectResponse.ObjectResponse;
import com.nash.Substance.Substance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/allergy")
public class AllergyController {

    @Autowired
    private AllergyService allergyService;

    @GetMapping
    ObjectResponse findAll() {
        ObjectResponse res = new ObjectResponse();
        try {
            res.setData(allergyService.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PostMapping
    ObjectResponse save(@RequestBody Allergy allergy) {
        ObjectResponse res = new ObjectResponse();
        try {
            allergyService.save(allergy);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
