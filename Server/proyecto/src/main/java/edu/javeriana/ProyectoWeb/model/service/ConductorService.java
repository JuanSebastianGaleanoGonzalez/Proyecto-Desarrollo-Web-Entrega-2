package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

    public List<Conductor> getConductores(){
        try{
            return (List<Conductor>) conductorRepository.findAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Conductor getConductor(long id){
        try{
            return conductorRepository.findById(id).orElseThrow();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public void addConductor(Conductor conductor){
        conductorRepository.save(conductor);
    }

    public void removeConductor(long id){
        conductorRepository.deleteById(id);
    }
}
