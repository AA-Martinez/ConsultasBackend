package com.nash.Job;

import com.nash.Disease.Disease;
import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    ObjectResponse saveModel(@RequestBody JobModel jobModel) {
        ObjectResponse res = new ObjectResponse();
        try{
            jobService.saveModel(jobModel);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
