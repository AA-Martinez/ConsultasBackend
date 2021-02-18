package com.nash.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public void save(File file) {
        fileRepository.save(file);
    }

    public ArrayList<File> getFilesFromAppoinemnt(Long appointmentId) {
        return (ArrayList<File>) fileRepository.findAllByAppointmentId(appointmentId);
    }
}
