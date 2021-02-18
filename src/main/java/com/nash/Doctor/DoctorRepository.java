package com.nash.Doctor;

import com.nash.AppUser.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findById(Long id, Pageable pageable);
    Doctor findByAppUser(AppUser appUser);
}