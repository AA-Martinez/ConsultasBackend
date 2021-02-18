package com.nash.File;

import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    ObjectResponse save(@RequestBody File file) {
        ObjectResponse res = new ObjectResponse();
        try{
            fileService.save(file);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/appointment/{appointmentId}")
    ObjectResponse findAppointmentsById(@PathVariable("appointmentId") Long appointmentId) {
        ObjectResponse res = new ObjectResponse();
        try{
            //TODO: Make Patient DTO that does not return its appts
            res.setData(fileService.getFilesFromAppoinemnt(appointmentId));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

}
