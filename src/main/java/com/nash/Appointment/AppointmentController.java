package com.nash.Appointment;

import com.nash.Allergy.Allergy;
import com.nash.Doctor.Doctor;
import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/status/page")
    ObjectResponse findByStatus(
            @RequestParam Integer status,
            @RequestParam Integer page,
            @RequestParam Integer pageSize
    ) {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(appointmentService.findByStatusPaginated(status, page, pageSize));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/{appointmentId}")
    ObjectResponse findAll(@PathVariable("appointmentId") Long appointmentId) {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(appointmentService.findAllByAppointmentId(appointmentId));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/patient/page")
    ObjectResponse findAppointmentsOfPatient(
            @RequestParam Long patientId,
            @RequestParam Integer page,
            @RequestParam Integer pageSize
    ) {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(appointmentService.appointmentsOfPatientPaginated(patientId, page, pageSize));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PostMapping
    ObjectResponse save(@RequestBody AppointmentModel appointment) {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(appointmentService.saveModel(appointment));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PutMapping("/{appointmentId}/close")
    ObjectResponse save(@PathVariable Long appointmentId) {
        ObjectResponse res = new ObjectResponse();
        try{
            appointmentService.closeAppointment(appointmentId);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/patient/{patientId}")
    ObjectResponse findAppointmentsOfPatient(@PathVariable("patientId") Long patientId) {
        ObjectResponse res = new ObjectResponse();
        try{
            res.setData(appointmentService.appointmentsOfPatient(patientId));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }


}
