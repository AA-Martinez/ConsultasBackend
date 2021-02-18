package com.nash.Degree;

import com.nash.Appointment.AppointmentModel;
import com.nash.Doctor.Doctor;
import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/degree")
public class DegreeController {

    @Autowired
    private DegreeService degreeService;

    @PostMapping
    ObjectResponse save(@RequestBody DegreeModel degreeModel) {
        ObjectResponse res = new ObjectResponse();
        try{
            degreeService.save(degreeModel);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping
    ObjectResponse getAll() {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(degreeService.getDegrees());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/specialty")
    ObjectResponse getSpecialties() {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(degreeService.getSpecialties());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }


    @GetMapping("/specialty/doctor")
    ObjectResponse getSpecialtiesAndDoctors() {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(degreeService.getSpecialtiesExtended());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
