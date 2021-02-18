package com.nash.Treatment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;

    public void createTreatment(Treatment treatment) {
        treatmentRepository.save(treatment);

    }
}
