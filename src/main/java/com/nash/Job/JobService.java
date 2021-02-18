package com.nash.Job;

import com.nash.Doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public void save(Job job) {
        jobRepository.save(job);
    }

    public void saveModel(JobModel jobModel) {
        Job job = new Job();
        Doctor doctor = new Doctor(jobModel.getDoctorId());
        job.setDescription(jobModel.getDescription());
        job.setDoctor(doctor);
        job.setEndYear(jobModel.getEndYear());
        job.setStartYear(jobModel.getEndYear());
        job.setWorkplace(jobModel.getWorkplace());
        save(job);
    }

}
