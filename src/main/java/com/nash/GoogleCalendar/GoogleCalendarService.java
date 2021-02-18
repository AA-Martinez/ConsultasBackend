package com.nash.GoogleCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class GoogleCalendarService {

    @Autowired
    GoogleCalendarRepository googleCalendarRepository;

    public void save(GoogleCalendar googleCalendar) {
        googleCalendarRepository.save(googleCalendar);
    }

    public ArrayList<GoogleCalendar> findAll() {
        return (ArrayList<GoogleCalendar>) googleCalendarRepository.findAll();
    }

    public void addCalendarToPatient(GoogleCalendar googleCalendar) {
        googleCalendar.setCreationTimeStamp(LocalDateTime.now());
        googleCalendarRepository.save(googleCalendar);
    }
}
