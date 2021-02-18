package com.nash.Treatment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nash.Appointment.Appointment;
import com.nash.Doctor.Doctor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    LocalDateTime startTimeStamp, endTimeStamp;


    @ManyToOne
    @JoinColumn(name="appointmentId", nullable=false)
    @JsonBackReference(value = "appointment_treatments")
    private Appointment appointment;


}
