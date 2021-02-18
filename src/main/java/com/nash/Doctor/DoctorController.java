package com.nash.Doctor;

import com.nash.Appointment.AppointmentModel;
import com.nash.ObjectResponse.ObjectResponse;
import com.nash.Patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping
    ObjectResponse findAll(){
        ObjectResponse res = new ObjectResponse();
        try {
            res.setData(doctorService.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/{doctorId}")
    ObjectResponse findById(@PathVariable("doctorId") Long doctorId){
        ObjectResponse res = new ObjectResponse();
        try {
            Doctor doctor = doctorService.findById(doctorId);
            res.setData(doctor);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/appUser/{appUserId}")
    ObjectResponse findByAppUserId(@PathVariable("appUserId") Long appUserId){
        ObjectResponse res = new ObjectResponse();
        try {
            Doctor doctor = doctorService.findByAppUserId(appUserId);
            res.setData(doctor);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }


    @PostMapping
    ObjectResponse findAppointmentsById(@RequestBody DoctorModel doctorModel) {
        ObjectResponse res = new ObjectResponse();
        try{
            doctorService.save(doctorModel);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/{doctorId}/appointment/page")
    ObjectResponse findAppointmentsById(
            @PathVariable("doctorId") Long doctorId,
            @RequestParam Integer page,
            @RequestParam Integer pageSize
    ) {
        ObjectResponse res = new ObjectResponse();
        try{
            //TODO: Make Patient DTO that does not return its appts
            res.setData(doctorService.findAppointmentsOfDoctorPaginated(doctorId, page, pageSize));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PutMapping("/appointment/{appointmentId}")
    ObjectResponse addDoctorToAppointment(@PathVariable("appointmentId") Long appointmentId, @RequestBody List<Doctor> doctors) {
        ObjectResponse res = new ObjectResponse();
        try {
            doctorService.saveDoctorsIntoAppointment(appointmentId,doctors);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

}
