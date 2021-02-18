package com.nash.Patient;

import com.nash.Allergy.Allergy;
import com.nash.AppUser.AppUser;
import com.nash.Appointment.Appointment;
import com.nash.GoogleCalendar.GoogleCalendar;
import com.nash.Disease.Disease;
import com.nash.Medication.Medication;
import com.nash.Substance.Substance;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String weight, height;
    private LocalDateTime creationTimeStamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appUserId", referencedColumnName = "id")
    private AppUser appUser;

    @OneToMany(mappedBy="patient")
    private Set<Appointment> appointments;

    @ManyToMany
    @JoinTable(
            name = "patient_diseases",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    Set<Disease> diseases;

    @ManyToMany
    @JoinTable(
            name = "patient_allergies",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id"))
    Set<Allergy> allergies;

    @ManyToMany
    @JoinTable(
            name = "patient_medications",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id"))
    Set<Medication> medications;

    @ManyToMany
    @JoinTable(
            name = "patient_substances",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "substance_id"))
    Set<Substance> substances;

    @OneToMany(mappedBy="patient")
    private Set<GoogleCalendar> googleCalendars;

    public Patient() {
    }

    public Patient(Long id) {
        this.id = id;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    public Set<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<Allergy> allergies) {
        this.allergies = allergies;
    }

    public Set<Medication> getMedications() {
        return medications;
    }

    public void setMedications(Set<Medication> medications) {
        this.medications = medications;
    }

    public Set<Substance> getSubstances() {
        return substances;
    }

    public void setSubstances(Set<Substance> substances) {
        this.substances = substances;
    }

    public Set<GoogleCalendar> getGoogleCalendars() {
        return googleCalendars;
    }

    public void setGoogleCalendars(Set<GoogleCalendar> googleCalendars) {
        this.googleCalendars = googleCalendars;
    }
}
