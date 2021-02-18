package com.nash.File;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findAllByAppointmentId(Long appointmentId);
}