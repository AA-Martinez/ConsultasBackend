package com.nash.GoogleCalendar;

import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/googleCalendar")
public class GoogleCalendarController {

    @Autowired
    private GoogleCalendarService googleCalendarService;

    @GetMapping
    ObjectResponse findAll() {
        ObjectResponse res = new ObjectResponse();
        try {
            res.setData(googleCalendarService.findAll());
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PostMapping
    ObjectResponse addCalendarToPatient(@RequestBody GoogleCalendar googleCalendar) {
        ObjectResponse res = new ObjectResponse();
        try {
            googleCalendarService.addCalendarToPatient(googleCalendar);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

}
