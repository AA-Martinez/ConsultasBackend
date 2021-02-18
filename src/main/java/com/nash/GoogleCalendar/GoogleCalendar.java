package com.nash.GoogleCalendar;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nash.Patient.Patient;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GoogleCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    LocalDateTime creationTimeStamp;

    String googleCalendarId;

    @ManyToOne
    @JoinColumn(name="patientId", nullable=false)
    @JsonBackReference(value = "patient_google_calendars")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoogleCalendarId() {
        return googleCalendarId;
    }

    public void setGoogleCalendarId(String googleCalendarId) {
        this.googleCalendarId = googleCalendarId;
    }

    public LocalDateTime getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(LocalDateTime creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
