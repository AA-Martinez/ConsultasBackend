package com.nash.Patient;

import com.nash.Allergy.Allergy;
import com.nash.AppUser.AppUser;
import com.nash.AppUser.AppUserService;
import com.nash.Disease.Disease;
import com.nash.Doctor.Doctor;
import com.nash.Doctor.DoctorRepository;
import com.nash.Medication.Medication;
import com.nash.Substance.Substance;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppUserService appUserService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PatientService(PatientRepository patientRepository,
                         BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public Patient findById(Long idClient){
        return patientRepository.findById(idClient).get();
    }

    public Patient findByAppUserId(Long appUserId) {
        AppUser appUser = new AppUser(appUserId);
        return patientRepository.findByAppUser(appUser);
    }


    public void save(PatientModel patientModel){
        //Create new app user first
        AppUser appUser = new AppUser();
        appUser.setUsername(patientModel.getCi());
        appUser.setPassword(bCryptPasswordEncoder.encode(patientModel.getPassword()));
        appUser.setAddress(patientModel.getAddress());
        appUser.setBirthCountry(patientModel.getBirthCountry());
        appUser.setBirthDate(patientModel.getBirthDate());
        appUser.setCi(patientModel.getCi());
        appUser.setCity(patientModel.getCity());
        appUser.setCreationTimeStamp(LocalDateTime.now());
        appUser.setEmail(patientModel.getEmail());
        appUser.setGenre(patientModel.getGenre());
        appUser.setFirstName(patientModel.getFirstName());
        appUser.setLastName(patientModel.getLastName());
        appUser.setPhone(patientModel.getPhone());
        appUserService.save(appUser);
        Patient patient = new Patient();
        patient.setAppUser(appUser);
        patient.setWeight(patientModel.getWeight());
        patient.setHeight(patientModel.getHeight());
        patientRepository.save(patient);
    }

    public void savePatient(Patient patient){
        patientRepository.save(patient);

    }

    public ArrayList<Patient> findAll(){
        return (ArrayList<Patient>) patientRepository.findAll();
    }

    /*
        Function to save multiple allergies into one patien, without deleting old ones
     */
    public void saveAllergies(Long patiendId, List<Allergy> allergies) {
        Patient patient = findById(patiendId);
        Set<Allergy> patientAllergies = patient.getAllergies();
        for(int i = 0; i < allergies.size(); i++) {
            patientAllergies.add(allergies.get(i));
        }
        patient.setAllergies(patientAllergies);
        patientRepository.save(patient);
    }

    /*
        Function to save multiple medications into one patient, without deleting old ones
     */
    public void saveMedication(Long patiendId, List<Medication> medications) {
        Patient patient = findById(patiendId);
        Set<Medication> patientMedications = patient.getMedications();
        for(int i = 0; i < medications.size(); i++) {
            patientMedications.add(medications.get(i));
        }
        patient.setMedications(patientMedications);
        patientRepository.save(patient);
    }

    /*
        Function to save multiple diseases into one patient, without deleting old ones
     */
    public void saveDisease(Long patiendId, List<Disease> diseases) {
        Patient patient = findById(patiendId);
        Set<Disease> patientDiseases = patient.getDiseases();
        for(int i = 0; i < diseases.size(); i++) {
            patientDiseases.add(diseases.get(i));
        }
        patient.setDiseases(patientDiseases);
        patientRepository.save(patient);
    }

    /*
        Function to save multiple diseases into one patient, without deleting old ones
     */
    public void saveSubstances(Long patiendId, List<Substance> substances) {
        Patient patient = findById(patiendId);
        Set<Substance> patientSubstances = patient.getSubstances();
        for(int i = 0; i < substances.size(); i++) {
            patientSubstances.add(substances.get(i));
        }
        patient.setSubstances(patientSubstances);
        patientRepository.save(patient);
    }

    /*
       Function to delete multiple allergies into one patien, without deleting old ones
    */
    public void deleteAllergies(Long patiendId, List<Allergy> allergies) {
        Patient patient = findById(patiendId);
        Set<Allergy> newPatientAllergies = new HashSet<>();

        Iterator<Allergy> itr = patient.getAllergies().iterator();

        while(itr.hasNext()){
            Allergy current = itr.next();
            boolean found = false;
            for(int i = 0; i < allergies.size(); i++) {
                if(current.getId() == allergies.get(i).getId()) {
                    found = true;
                }
            }
            if(!found) {
                newPatientAllergies.add(current);
            }
        }

        patient.setAllergies(newPatientAllergies);

        patientRepository.save(patient);
    }

    /*
        Function to delete multiple medications into one patient, without deleting old ones
     */
    public void deleteMedication(Long patiendId, List<Medication> medications) {
        Patient patient = findById(patiendId);
        Set<Medication> newPatientMedications = new HashSet<>();

        Iterator<Medication> itr = patient.getMedications().iterator();

        while(itr.hasNext()){
            Medication current = itr.next();
            boolean found = false;
            for(int i = 0; i < medications.size(); i++) {
                if(current.getId() == medications.get(i).getId()) {
                    found = true;
                }
            }
            if(!found) {
                newPatientMedications.add(current);
            }
        }

        patient.setMedications(newPatientMedications);

        patientRepository.save(patient);
    }

    /*
        Function to delete multiple diseases into one patient, without deleting old ones
     */
    public void deleteDisease(Long patiendId, List<Disease> diseases) {
        Patient patient = findById(patiendId);
        Set<Disease> newPatientDiseases = new HashSet<>();

        Iterator<Disease> itr = patient.getDiseases().iterator();

        while(itr.hasNext()){
            Disease current = itr.next();
            boolean found = false;
            for(int i = 0; i < diseases.size(); i++) {
                if(current.getId() == diseases.get(i).getId()) {
                    found = true;
                }
            }
            if(!found) {
                newPatientDiseases.add(current);
            }
        }

        patient.setDiseases(newPatientDiseases);

        patientRepository.save(patient);
    }

    /*
        Function to delete multiple diseases into one patient, without deleting old ones
     */
    public void deleteSubstances(Long patiendId, List<Substance> substances) {
        Patient patient = findById(patiendId);
        Set<Substance> newPatientSubstances = new HashSet<>();

        Iterator<Substance> itr = patient.getSubstances().iterator();

        while(itr.hasNext()){
            Substance current = itr.next();
            boolean found = false;
            for(int i = 0; i < substances.size(); i++) {
                if(current.getId() == substances.get(i).getId()) {
                    found = true;
                }
            }
            if(!found) {
                newPatientSubstances.add(current);
            }
        }

        patient.setSubstances(newPatientSubstances);

        patientRepository.save(patient);
    }

}
