package com.nash.Patient;

import com.nash.AppUser.AppUser;
import com.nash.Doctor.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByAppUser(AppUser appUser);
}
