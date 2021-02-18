package com.nash.Appointment;

import java.time.LocalDateTime;

public class AppointmentModel {
    Long patientId;

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
