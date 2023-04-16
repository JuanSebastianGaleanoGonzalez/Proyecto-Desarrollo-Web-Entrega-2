package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.ConductorTransmilenio;
import edu.javeriana.ProyectoWeb.model.repository.ConductorTransmilenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class ConductorTransmilenioService {
    @Autowired
    private ConductorTransmilenioRepository conductorTransmilenioRepository;

    public long getIdConductor(long id){
        try{
            ConductorTransmilenio aux = conductorTransmilenioRepository.findById(id).orElseThrow();
            return aux.getConductorId();
        }catch(NoSuchElementException exception){
            return -1;
        }
    }
}
