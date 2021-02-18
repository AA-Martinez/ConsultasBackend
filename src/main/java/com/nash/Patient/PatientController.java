package com.nash.Patient;

import com.nash.Allergy.Allergy;
import com.nash.Disease.Disease;
import com.nash.Doctor.Doctor;
import com.nash.Medication.Medication;
import com.nash.ObjectResponse.ObjectResponse;
import com.nash.Substance.Substance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{patientId}")
    ObjectResponse findById(@PathVariable("patientId") Long patientId){
        ObjectResponse res = new ObjectResponse();
        try {
            Patient patient = patientService.findById(patientId);
            res.setData(patient);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @GetMapping("/appUser/{appUserId}")
    ObjectResponse findByAppUserId(@PathVariable("appUserId") Long appUserId){
        ObjectResponse res = new ObjectResponse();
        try {
            Patient patient = patientService.findByAppUserId(appUserId);
            res.setData(patient);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }


    @PostMapping
    ObjectResponse save(@RequestBody PatientModel patientModel){
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.save(patientModel);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PutMapping("/{patientId}/allergy")
    ObjectResponse saveAllergies(@PathVariable("patientId") Long patientId,@RequestBody List<Allergy> allergies) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.saveAllergies(patientId,allergies);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PutMapping("/{patientId}/medication")
    ObjectResponse saveMedications(@PathVariable("patientId") Long patientId,@RequestBody List<Medication> medications) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.saveMedication(patientId,medications);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PutMapping("/{patientId}/disease")
    ObjectResponse saveDiseases(@PathVariable("patientId") Long patientId,@RequestBody List<Disease> diseases) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.saveDisease(patientId,diseases);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @PutMapping("/{patientId}/substance")
    ObjectResponse saveSubstances(@PathVariable("patientId") Long patientId,@RequestBody List<Substance> substances) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.saveSubstances(patientId, substances);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @DeleteMapping("/{patientId}/allergy")
    ObjectResponse deleteAllergies(@PathVariable("patientId") Long patientId,@RequestBody List<Allergy> allergies) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.deleteAllergies(patientId,allergies);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @DeleteMapping("/{patientId}/medication")
    ObjectResponse deleteMedications(@PathVariable("patientId") Long patientId,@RequestBody List<Medication> medications) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.deleteMedication(patientId,medications);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @DeleteMapping("/{patientId}/disease")
    ObjectResponse deleteDiseases(@PathVariable("patientId") Long patientId,@RequestBody List<Disease> diseases) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.deleteDisease(patientId,diseases);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

    @DeleteMapping("/{patientId}/substance")
    ObjectResponse deleteSubstances(@PathVariable("patientId") Long patientId,@RequestBody List<Substance> substances) {
        ObjectResponse res = new ObjectResponse();
        try {
            patientService.deleteSubstances(patientId, substances);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }

}
