package com.nash.Message;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nash.AppUser.AppUser;
import com.nash.Appointment.Appointment;
import com.nash.File.File;
import com.nash.Patient.Patient;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String text;

    LocalDateTime creationTimeStamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appUserId", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name="appointmentId", nullable=false)
    @JsonBackReference(value = "appointment_messages")
    private Appointment appointment;

    public Message() {
    }

    public Message(String text, LocalDateTime creationTimeStamp, AppUser appUser, Appointment appointment) {
        this.text = text;
        this.creationTimeStamp = creationTimeStamp;
        this.appUser = appUser;
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(LocalDateTime creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
