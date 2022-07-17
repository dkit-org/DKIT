package org.dkit.service;

import org.dkit.domain.Application;
import org.dkit.domain.Container;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl {

    public Optional<Application> createApplication(){
        return Optional.empty();
    }

    public void deleteApplication(String id){

    }

    public void startApplication(String id){

    }

    public void restartApplication(String id){

    }

    public void stopApplication(String id){

    }

    public Optional<String> getLogs(String id){
        return Optional.empty();
    }

    public List<Container> getContainers(String id){
        return new ArrayList<>();
    }
}
