package com.nash.Module;

import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping
    ObjectResponse modules() {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(moduleService.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    };

}
