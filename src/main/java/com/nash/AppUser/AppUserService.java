package com.nash.AppUser;

import com.nash.Patient.Patient;
import com.nash.Patient.PatientRepository;
import com.nash.Patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AppUserService {


    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PatientService patientService;

    public void save(AppUser appUser){
        appUser.setUsername(appUser.getCi());
        appUserRepository.save(appUser);
        //Creating Genesis Block For New User
    }

    public void update(AppUserModel appUserModel){
        AppUser appUser = appUserRepository.findByUsername(appUserModel.getUsername());
        appUser.setPhone(appUserModel.getPhone());
        appUser.setLastName(appUserModel.getLastName());
        appUser.setFirstName(appUserModel.getFirstName());
        appUser.setEmail(appUserModel.getEmail());
        appUser.setCity(appUserModel.getCity());
        appUser.setAddress(appUserModel.getAddress());
        appUserRepository.save(appUser);
        Patient patient = patientService.findByAppUserId(appUser.getId());
        patient.setWeight(appUserModel.getWeight());
        patient.setHeight(appUserModel.getHeight());
        patientService.savePatient(patient);

        //Creating Genesis Block For New User
    }


    public AppUser findById(Long idAppUser){
        return appUserRepository.findById(idAppUser).get();
    }


    public ArrayList<AppUser> findAll(){
        return (ArrayList<AppUser>) appUserRepository.findAll();
    }

    public HashMap<Long,AppUser> appUserHashMap(){
        HashMap<Long,AppUser> appUserHashMap = new HashMap<>();
        ArrayList<AppUser> appUsers = this.findAll();
        for(int i=0;i<appUsers.size();i++){
            appUserHashMap.put(appUsers.get(i).getId(),appUsers.get(i));
        }
        return appUserHashMap;
    }

}
