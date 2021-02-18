package com.nash.AppointmentEvent;

import com.nash.Appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentEventRepository extends JpaRepository<AppointmentEvent, Long> {
    List<AppointmentEvent> findAllByAppointment(Appointment appointment);
}