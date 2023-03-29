package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.Transmilenio;
import edu.javeriana.ProyectoWeb.model.repository.TransmilenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransmilenioService {

    @Autowired
    private TransmilenioRepository transmilenioRepository;

    public List<Transmilenio> getTransmilenios(){
        return (List<Transmilenio>) transmilenioRepository.findAll();
    }
    
    public Transmilenio getTransmilenio(Long id){
        try{
            return transmilenioRepository.findById(id).orElseThrow();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public void addTransmilenio(Transmilenio transmilenio){
        transmilenioRepository.save(transmilenio);
    }

    public void removeTransmilenio(Long id){
        transmilenioRepository.deleteById(id);
    }
}
