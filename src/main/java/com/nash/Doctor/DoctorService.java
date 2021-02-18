package com.nash.Doctor;

import com.nash.AppUser.AppUser;
import com.nash.AppUser.AppUserService;
import com.nash.Appointment.Appointment;
import com.nash.Appointment.AppointmentDTO;
import com.nash.Appointment.AppointmentService;
import com.nash.AppointmentEvent.AppointmentEvent;
import com.nash.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppUserService appUserService;

    @Autowired
    AppointmentService appointmentService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public DoctorService(DoctorRepository doctorRepository,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void save(DoctorModel doctorModel) {

        //Create new app user first
        AppUser appUser = new AppUser();
        appUser.setUsername(doctorModel.getCi());
        appUser.setPassword(bCryptPasswordEncoder.encode(doctorModel.getPassword()));
        appUser.setAddress(doctorModel.getAddress());
        appUser.setBirthCountry(doctorModel.getBirthCountry());
        appUser.setBirthDate(doctorModel.getBirthDate());
        appUser.setCi(doctorModel.getCi());
        appUser.setCity(doctorModel.getCity());
        appUser.setCreationTimeStamp(LocalDateTime.now());
        appUser.setEmail(doctorModel.getEmail());
        appUser.setGenre(doctorModel.getGenre());
        appUser.setFirstName(doctorModel.getFirstName());
        appUser.setLastName(doctorModel.getLastName());
        appUser.setPhone(doctorModel.getPhone());
        appUserService.save(appUser);
        Doctor doctor = new Doctor();
        doctor.setAppUser(appUser);
        doctorRepository.save(doctor);

    }

    public Page<Doctor> findByIdPaginated(Long id, Integer page, Integer pageSize){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());
        return doctorRepository.findById(id,pageable);
    }

    public Page<AppointmentDTO> findAppointmentsOfDoctorPaginated(Long doctorId, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("lastUpdateTimeStamp").descending());
        Doctor doctor = findById(doctorId);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        Iterator<Appointment> itr = doctor.getAppointments().iterator(); // traversing over HashSet
        // System.out.println("Traversing over Set using Iterator");
        while(itr.hasNext()){
            Appointment appt = itr.next();
            appointmentDTOS.add(
                new AppointmentDTO(
                    appt.getId(),
                    appt.getCreationTimeStamp(),
                    appt.getCloseTimeStamp(),
                    appt.getLastUpdateTimeStamp(),
                    appt.getStatus(),
                    appt.getPatient(),
                    appt.getDoctors(),
                    appt.getMessages()
                ));
        }

        Page<AppointmentDTO> res = new PageImpl<>(appointmentDTOS, pageable, appointmentDTOS.size());
        return res;
    }

    public Doctor findById(Long doctorId) {
        return doctorRepository.findById(doctorId).get();
    }

    public Doctor findByAppUserId(Long appUserId) {
        AppUser appUser = new AppUser(appUserId);
        return doctorRepository.findByAppUser(appUser);
    }


    public void saveDoctorsIntoAppointment(Long appointmentId, List<Doctor> doctors){
        Appointment appointment = appointmentService.findById(appointmentId);
        appointment.setStatus(GlobalVariables.APPOINTMENT_IN_PROCCESS_STATUS); //Status 1 means the appointment has been taken by at least one doctor
        appointmentService.save(appointment);
        for(int i = 0; i < doctors.size(); i++) {
            Doctor doctor = findById(doctors.get(i).getId());
            doctor.getAppointments().add(appointment);
            doctorRepository.save(doctor);
        }
        AppointmentEvent appointmentEvent = new AppointmentEvent();
        appointmentEvent.setName("Un nuevo doctor está atendiendo la consulta.");
        appointmentEvent.setDescription(
                "El doctor " +
                        doctors.get(0).getAppUser().getFirstName() +
                        " " +
                        doctors.get(0).getAppUser().getLastName() +
                        "está atendiendo la consulta."
                );
        appointmentEvent.setCreationTimeStamp(LocalDateTime.now());
        appointmentEvent.setAppointment(appointment);
        appointmentEvent.setType(GlobalVariables.NEW_DOCTOR_IN_APPOINTMENT_EVENT_TYPE);
    }

    public ArrayList<DoctorDTO> findAll() {
        ArrayList<Doctor> doctors = (ArrayList<Doctor>) doctorRepository.findAll();
        ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
        for(int i = 0; i < doctors.size(); i++) {
            doctorDTOS.add(new DoctorDTO(
                    doctors.get(i).getId(),
                    doctors.get(i).getAppUser(),
                    doctors.get(i).getDegrees(),
                    doctors.get(i).getJobs()
            ));
        }
        return doctorDTOS;
    }
    
    public DoctorDTO getDoctorDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getAppUser(),
                doctor.getDegrees(),
                doctor.getJobs()
        );
    }

}
