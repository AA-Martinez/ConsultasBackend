package com.nash.AppointmentEvent;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nash.Appointment.Appointment;
import com.nash.Patient.Patient;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class AppointmentEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name, description;

    Integer type;

    LocalDateTime creationTimeStamp;

    @ManyToOne
    @JoinColumn(name="appointmentId", nullable=false)
    @JsonBackReference(value = "appointment_appointmentEvents")
    private Appointment appointment;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(LocalDateTime creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
