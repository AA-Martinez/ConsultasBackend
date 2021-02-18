package com.nash.Doctor;

import com.nash.AppUser.AppUser;
import com.nash.Appointment.Appointment;
import com.nash.Degree.Degree;
import com.nash.Job.Job;

import javax.persistence.*;
import java.util.Set;

public class DoctorDTO {
    private Long id;
    private AppUser appUser;
    Set<Appointment> appointments;
    private Set<Degree> degrees;
    private Set<Job> jobs;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, AppUser appUser, Set<Degree> degrees, Set<Job> jobs) {
        this.id = id;
        this.appUser = appUser;
        this.appointments = appointments;
        this.degrees = degrees;
        this.jobs = jobs;
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
