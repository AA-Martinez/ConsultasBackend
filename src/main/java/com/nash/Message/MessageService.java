package com.nash.Message;

import com.nash.AppUser.AppUser;
import com.nash.Appointment.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void save(Message message) {
        messageRepository.save(message);
    }

    public void saveModel(MessageModel messageModel) {
        Appointment appointment = new Appointment(messageModel.getAppointmentId());
        AppUser appUser = new AppUser(messageModel.getAppUserId());
        Message message = new Message(messageModel.getText(), LocalDateTime.now(),appUser,appointment);
        messageRepository.save(message);
    }
}
