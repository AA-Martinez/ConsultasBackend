package com.nash.AppointmentEvent;

import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/appointmentEvent")
public class AppointmentEventController {

    @Autowired
    private AppointmentEventService appointmentEventService;

    @GetMapping
    ObjectResponse findAllByAppointmentId(@PathParam("appointmentId") Long appointmentId) {
        ObjectResponse res = new ObjectResponse();
        try {
            res.setData(appointmentEventService.findAllByAppointmentId(appointmentId));
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PostMapping
    ObjectResponse saveModel(@RequestBody AppointmentEventModel appointmentEventModel) {
        ObjectResponse res = new ObjectResponse();
        try{
            appointmentEventService.saveModel(appointmentEventModel);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
