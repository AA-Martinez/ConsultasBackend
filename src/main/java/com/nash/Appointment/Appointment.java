package com.nash.Appointment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nash.AppUser.AppUser;
import com.nash.AppointmentEvent.AppointmentEvent;
import com.nash.Degree.Degree;
import com.nash.Disease.Disease;
import com.nash.Doctor.Doctor;
import com.nash.Message.Message;
import com.nash.Patient.Patient;
import com.nash.Treatment.Treatment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    LocalDateTime creationTimeStamp;
    LocalDateTime closeTimeStamp;
    LocalDateTime lastUpdateTimeStamp;
    Integer status;

    //User that creates and closes the appointment (patient)
    @ManyToOne
    @JoinColumn(name="patientId", nullable=false)
    @JsonBackReference(value = "patient_appointments")
    private Patient patient;

    @ManyToMany(mappedBy = "appointments")
    Set<Doctor> doctors;

    @OneToMany(mappedBy="appointment")
    private Set<Message> messages;

    @OneToMany(mappedBy="appointment")
    private Set<AppointmentEvent> appointmentEvents;

    @OneToMany(mappedBy="appointment")
    private Set<Treatment> treatments;

    public Appointment(){};

    public Appointment(LocalDateTime creationTimeStamp, LocalDateTime lastUpdateTimeStamp, Integer status, Patient patient) {
        this.creationTimeStamp = creationTimeStamp;
        this.closeTimeStamp = closeTimeStamp;
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
        this.status = status;
        this.patient = patient;
    }

    public Appointment(Long id) {
        this.id = id;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<AppointmentEvent> getAppointmentEvents() {
        return appointmentEvents;
    }

    public void setAppointmentEvents(Set<AppointmentEvent> appointmentEvents) {
        this.appointmentEvents = appointmentEvents;
    }
}
