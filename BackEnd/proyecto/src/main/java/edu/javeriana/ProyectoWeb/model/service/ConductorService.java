package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

    public List<Conductor> listarConductores(){
        return (List<Conductor>) conductorRepository.findAll();
    }

    public Conductor buscarConductor(long id){
        Conductor aux = conductorRepository.findById(id).orElseThrow();
        return aux;
    }

    public List<Conductor> buscarConductorCedula(int cedula){
        List<Conductor> auxiliares = new ArrayList<>();
        for(Conductor conductor: conductorRepository.findAll()){
            if(conductor.getCedula() == cedula){
                auxiliares.add(conductor);
            }
        }
        return auxiliares;
    }

    public void guardarConductor(Conductor conductor){
        conductorRepository.save(conductor);
    }

    public void eliminarConductor(Conductor conductor){
        conductorRepository.delete(conductor);
    }

}
