package com.nash.Degree;

import com.nash.Doctor.Doctor;
import com.nash.Doctor.DoctorDTO;
import com.nash.Doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class DegreeService {
    @Autowired
    DegreeRepository degreeRepository;

    @Autowired
    DoctorService doctorService;

    public void save(DegreeModel degreeModel) {
        Doctor doctor = new Doctor(degreeModel.getDoctorId());
        Degree degree = new Degree();
        degree.setDegree(degreeModel.getDegree());
        degree.setDoctor(doctor);
        degree.setEndYear(degreeModel.getEndYear());
        degree.setInstitution(degreeModel.getInstitution());
        degree.setStartYear(degreeModel.getStartYear());
        degree.setSpecialty(degreeModel.getSpecialty());
        degreeRepository.save(degree);
    }

    public ArrayList<Degree> getDegrees() {
        return (ArrayList<Degree>) degreeRepository.findAll();
    }

    public ArrayList<SpecialtyDTO> getSpecialties() {
        ArrayList<Degree> degrees = getDegrees();
        ArrayList<SpecialtyDTO> specialtyDTOS = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < degrees.size(); i++) {
            String specialty = degrees.get(i).getSpecialty();
            if(!set.contains(specialty)) {
                specialtyDTOS.add(new SpecialtyDTO(specialty));
                set.add(specialty);
            }
        }
        return specialtyDTOS;
    }

    public HashMap<String,ArrayList<DoctorDTO>> getSpecialtiesExtended() {
        ArrayList<Degree> degrees = getDegrees();
        HashSet<String> set = new HashSet<>();
        HashMap<String,ArrayList<DoctorDTO>> specialties = new HashMap<>();
        for(int i = 0; i < degrees.size(); i++) {
            String aux = degrees.get(i).getSpecialty().toLowerCase();
            if(!set.contains(aux)) {
                specialties.put(aux,new ArrayList<>());
                specialties.get(aux).add((doctorService.getDoctorDTO(degrees.get(i).getDoctor())));
                set.add(aux);
            } else {
                specialties.get(aux).add((doctorService.getDoctorDTO(degrees.get(i).getDoctor())));
            }
        }
        return specialties;
    }
}
