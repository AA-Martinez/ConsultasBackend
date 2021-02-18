package com.nash.Appointment;

import com.nash.AppUser.AppUser;
import com.nash.AppUser.AppUserService;
import com.nash.AppointmentEvent.AppointmentEvent;
import com.nash.AppointmentEvent.AppointmentEventModel;
import com.nash.AppointmentEvent.AppointmentEventRepository;
import com.nash.AppointmentEvent.AppointmentEventService;
import com.nash.Doctor.Doctor;
import com.nash.Doctor.DoctorService;
import com.nash.GlobalVariables;
import com.nash.Message.Message;
import com.nash.Message.MessageService;
import com.nash.Patient.Patient;
import com.nash.Patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppUserService appUserService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    MessageService messageService;

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentEventService appointmentEventService;

    Appointment saveModel(AppointmentModel appt) {
        Patient patient = patientService.findById(appt.patientId);
        Appointment appointment =
                new Appointment(
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        GlobalVariables.APPOINTMENT_OPEN_STATUS,
                        patient
                );
        appointmentRepository.save(appointment);
        Message message = new Message();
        AppUser appUser = patient.getAppUser();
        if(appt.getMessage() != null) {
            message.setText(appt.getMessage());
            message.setCreationTimeStamp(LocalDateTime.now());
            message.setAppUser(appUser);
            message.setAppointment(appointment);
        }
        AppointmentEventModel appointmentEventModel = new AppointmentEventModel();
        appointmentEventModel.setAppointmentId(appointment.getId());
        appointmentEventModel.setDescription("Se ha creado la consulta.");
        appointmentEventModel.setName("Consulta creada");
        appointmentEventModel.setType(GlobalVariables.NEW_APPOINTMENT_EVENT_TYPE);
        appointmentEventService.saveModel(appointmentEventModel);
        messageService.save(message);
        return appointment;
    }

    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public Appointment findById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).get();
    }

    Appointment findAllByAppointmentId(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).get();
    }

    public Page<AppointmentDTO> findByStatusPaginated(Integer status, Integer page, Integer pageSize){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("lastUpdateTimeStamp").descending());
        List<Appointment> appointments = appointmentRepository.findByStatus(status);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for(int i = 0; i < appointments.size(); i++) {
            appointmentDTOS.add(new AppointmentDTO(
                    appointments.get(i).getId(),
                    appointments.get(i).getCreationTimeStamp(),
                    appointments.get(i).getCloseTimeStamp(),
                    appointments.get(i).getLastUpdateTimeStamp(),
                    appointments.get(i).getStatus(),
                    appointments.get(i).getPatient(),
                    appointments.get(i).getDoctors(),
                    appointments.get(i).getMessages()
            ));
        }
        Page<AppointmentDTO> res = new PageImpl<>(appointmentDTOS, pageable, appointments.size());
        return res;
    }

    public Page<AppointmentDTO> appointmentsOfPatientPaginated(Long patientId, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("lastUpdateTimeStamp").descending());
        Patient patient = new Patient(patientId);
        List<Appointment> appointments = appointmentRepository.findAllByPatient(patient);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for(int i = 0; i < appointments.size(); i++) {
            appointmentDTOS.add(new AppointmentDTO(
                    appointments.get(i).getId(),
                    appointments.get(i).getCreationTimeStamp(),
                    appointments.get(i).getCloseTimeStamp(),
                    appointments.get(i).getLastUpdateTimeStamp(),
                    appointments.get(i).getStatus(),
                    appointments.get(i).getPatient(),
                    appointments.get(i).getDoctors(),
                    appointments.get(i).getMessages()
            ));
        }
        Page<AppointmentDTO> res = new PageImpl<>(appointmentDTOS, pageable, appointments.size());
        return res;
    }

    public ArrayList<Appointment> appointmentsOfPatient(Long patientId) {
        Patient patient = new Patient(patientId);
        return (ArrayList<Appointment>) appointmentRepository.findAllByPatient(patient);
    }

    public void closeAppointment(Long appointmentId) {
        Appointment appointment = findById(appointmentId);
        appointment.setStatus(GlobalVariables.APPOINTMENT_CLOSED_STATUS);
        save(appointment);

    }
}
