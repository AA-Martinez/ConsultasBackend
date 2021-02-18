package com.nash.Message;

import com.nash.Doctor.DoctorModel;
import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    ObjectResponse save(@RequestBody MessageModel messageModel) {
        ObjectResponse res = new ObjectResponse();
        try{
            messageService.saveModel(messageModel);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }
    }
}
