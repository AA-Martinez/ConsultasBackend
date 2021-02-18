package com.nash.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ModuleService moduleService;

    public HashMap<Long, Module> getModuleHashMap() {
        ArrayList<Module> properties = (ArrayList<Module>) moduleRepository.findAll();
        HashMap<Long, Module> propertyHashMap = new HashMap<>();
        for(int i=0;i<properties.size();i++){
            Long id = properties.get(i).getId();
            propertyHashMap.put(id,properties.get(i));
        }
        return propertyHashMap;
    }

    public ArrayList<Module> findAll(){
        return (ArrayList<Module>) moduleRepository.findAll();
    }
}
