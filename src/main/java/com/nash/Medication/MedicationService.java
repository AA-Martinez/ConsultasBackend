package com.nash.Medication;

import com.nash.Disease.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MedicationService {
    @Autowired
    MedicationRepository medicationRepository;

    public ArrayList<Medication> findAll() {
        return (ArrayList<Medication>) medicationRepository.findAll();
    }

    public void save(Medication medication) { medicationRepository.save(medication); }

}
