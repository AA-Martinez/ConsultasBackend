package com.nash.Doctor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nash.AppUser.AppUser;
import com.nash.Appointment.Appointment;
import com.nash.Degree.Degree;
import com.nash.Job.Job;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appUserId", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToMany
    @JoinTable(
            name = "doctor_appointments",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id"))
    @JsonBackReference
    Set<Appointment> appointments;

    @OneToMany(mappedBy="doctor")
    private Set<Degree> degrees;

    @OneToMany(mappedBy="doctor")
    private Set<Job> jobs;

    public Doctor() {
    }

    public Doctor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}
