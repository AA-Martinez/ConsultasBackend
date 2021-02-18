package com.nash.Allergy;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AllergyService {

    @Autowired
    AllergyRepository allergyRepository;

    public void save(Allergy allergy) {
        allergyRepository.save(allergy);
    }

    public ArrayList<Allergy> findAll() {
        return (ArrayList<Allergy>) allergyRepository.findAll();
    }
}
