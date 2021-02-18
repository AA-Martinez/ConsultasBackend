package com.nash.Degree;

import com.nash.Doctor.DoctorDTO;

import java.util.ArrayList;

public class SpecialtyDTO {
    String specialty;

    ArrayList<DoctorDTO> doctorDTOS;

    public ArrayList<DoctorDTO> getDoctorDTOS() {
        return doctorDTOS;
    }

    public void setDoctorDTOS(ArrayList<DoctorDTO> doctorDTOS) {
        this.doctorDTOS = doctorDTOS;
    }

    public SpecialtyDTO(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
