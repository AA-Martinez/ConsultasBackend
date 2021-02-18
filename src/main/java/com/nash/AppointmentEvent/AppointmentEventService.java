package com.nash.AppointmentEvent;

import com.nash.Appointment.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class AppointmentEventService {

    @Autowired
    AppointmentEventRepository appointmentEventRepository;

    public void save(AppointmentEvent appointmentEvent) {
        appointmentEventRepository.save(appointmentEvent);
    }

    public void saveModel(AppointmentEventModel appointmentEventModel) {
        Appointment appointment = new Appointment(appointmentEventModel.getAppointmentId());
        AppointmentEvent appointmentEvent = new AppointmentEvent();
        appointmentEvent.setAppointment(appointment);
        appointmentEvent.setCreationTimeStamp(LocalDateTime.now());
        appointmentEvent.setDescription(appointmentEventModel.getDescription());
        appointmentEvent.setName(appointmentEventModel.getName());
        appointmentEvent.setType(appointmentEventModel.getType());
        appointmentEventRepository.save(appointmentEvent);
    }


    public ArrayList<AppointmentEvent> findAll() {
        return (ArrayList<AppointmentEvent>) appointmentEventRepository.findAll();
    }

    public ArrayList<AppointmentEvent> findAllByAppointmentId(Long appointmentId) {
        Appointment appointment = new Appointment(appointmentId);
        return (ArrayList<AppointmentEvent>) appointmentEventRepository.findAllByAppointment(appointment);
    }
}
