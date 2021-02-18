package com.nash.Appointment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nash.Doctor.Doctor;
import com.nash.Message.Message;
import com.nash.Patient.Patient;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Set;

public class AppointmentDTO {
    private Long id;

    LocalDateTime creationTimeStamp;
    LocalDateTime closeTimeStamp;
    LocalDateTime lastUpdateTimeStamp;
    Integer status;

    //User that creates and closes the appointment (patient)
    private Patient patient;

    Set<Doctor> doctors;

    Set<Message> messages;

    public AppointmentDTO(Long id, LocalDateTime creationTimeStamp, LocalDateTime closeTimeStamp, LocalDateTime lastUpdateTimeStamp, Integer status, Patient patient, Set<Doctor> doctors, Set<Message> messages) {
        this.id = id;
        this.creationTimeStamp = creationTimeStamp;
        this.closeTimeStamp = closeTimeStamp;
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
        this.status = status;
        this.patient = patient;
        this.doctors = doctors;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(LocalDateTime creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public LocalDateTime getCloseTimeStamp() {
        return closeTimeStamp;
    }

    public void setCloseTimeStamp(LocalDateTime closeTimeStamp) {
        this.closeTimeStamp = closeTimeStamp;
    }

    public LocalDateTime getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(LocalDateTime lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
