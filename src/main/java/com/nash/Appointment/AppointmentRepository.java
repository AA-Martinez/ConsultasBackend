package com.nash.Appointment;

import com.nash.Jwt.Jwt;
import com.nash.Patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllById(Long appointmentId);
    List<Appointment> findByStatus(Integer status);
    List<Appointment> findAllByPatient(Patient patient);
}
