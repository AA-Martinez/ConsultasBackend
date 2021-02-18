package com.nash.Disease;

import com.nash.Allergy.Allergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiseaseService {

    @Autowired
    DiseaseRepository diseaseRepository;

    public void save(Disease disease) {
        diseaseRepository.save(disease);
    }

    public ArrayList<Disease> findAll() {
        return (ArrayList<Disease>) diseaseRepository.findAll();
    }
}
