package com.nash.Substance;

import com.nash.Medication.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubstanceService {
    @Autowired
    SubstanceRepository substanceRepository;

    public void save(Substance substance) {
        substanceRepository.save(substance);
    }

    public ArrayList<Substance> findAll() {
        return (ArrayList<Substance>) substanceRepository.findAll();
    }
}
