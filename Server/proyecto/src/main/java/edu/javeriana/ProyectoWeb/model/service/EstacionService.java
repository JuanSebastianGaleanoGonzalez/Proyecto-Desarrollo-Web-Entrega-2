package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.Estacion;
import edu.javeriana.ProyectoWeb.model.repository.EstacionRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionService {
    @Autowired
    private EstacionRepository estacionRepository;

    public List<Estacion> getEstaciones(){
        return (List<Estacion>) estacionRepository.findAll();
    }

    public Estacion getEstacion(Long id){
        try{
            return estacionRepository.findById(id).orElseThrow();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public void addEstacion(Estacion estacion){
        estacionRepository.save(estacion);
    }

    public void removeEstacion(Long id){
        estacionRepository.deleteById(id);
    }
}
