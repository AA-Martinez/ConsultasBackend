package com.nash.Disease;

import com.nash.Message.MessageModel;
import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping
    ObjectResponse findAll() {
        ObjectResponse res = new ObjectResponse();
        try {
            res.setData(diseaseService.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PostMapping
    ObjectResponse save(@RequestBody Disease disease) {
        ObjectResponse res = new ObjectResponse();
        try{
            diseaseService.save(disease);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
