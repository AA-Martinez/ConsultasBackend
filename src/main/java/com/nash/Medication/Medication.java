package com.nash.Medication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nash.Patient.Patient;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name, description;

    @ManyToMany(mappedBy = "medications")
    @JsonBackReference(value = "patient_medications")
    Set<Patient> patients;

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
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
}
