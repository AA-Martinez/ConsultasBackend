package com.nash.AppUser;


import com.nash.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/appUser")
public class AppUserController {
	
    @Autowired
    AppUserService appUserService;

    public AppUserController(AppUserRepository appUserRepository,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    AppUser getEspecificUser(@RequestParam Long idAppUser){
        return appUserService.findById(idAppUser);
    }


    @PostMapping()
    public ObjectResponse updateAppUser(@RequestBody AppUserModel appUserModel) {
        ObjectResponse res = new ObjectResponse();
        try{
           //appUserService.save(user);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }


    @PostMapping("/sign-up")
    public ObjectResponse signUp(@RequestBody AppUser user) {
        System.out.println(user.toString());
        System.out.println(user.getUsername()+" - "+user.getPassword());
        ObjectResponse res = new ObjectResponse();
        try{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            appUserService.save(user);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }

    @PutMapping
    public ObjectResponse update(@RequestBody AppUserModel appUserModel) {
        ObjectResponse res = new ObjectResponse();
        try{
            appUserService.update(appUserModel);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }

}
