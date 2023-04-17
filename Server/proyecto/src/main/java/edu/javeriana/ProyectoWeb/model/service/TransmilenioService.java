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

    public Transmilenio addTransmilenio(Transmilenio transmilenio){
        try{
            transmilenioRepository.save(transmilenio);
            return transmilenio;
        }catch(Exception e){
            return null;
        }
    }

    public Transmilenio removeTransmilenio(Long id){
        Transmilenio transmilenio = transmilenioRepository.findById(id).get();
        Transmilenio transmilenioAux = new Transmilenio();
        transmilenioAux.setId(transmilenio.getId());
        transmilenioAux.setPlaca(transmilenio.getPlaca());
        transmilenioAux.setModelo(transmilenio.getModelo());
        transmilenioAux.setDia(transmilenio.getDia());
        try{
            transmilenioRepository.deleteById(id);
            return transmilenioAux;
        }catch(Exception e){
            return null;
        }

    }

    public Transmilenio updateTransmilenio(Transmilenio transmilenio){
        Transmilenio transmilenio2 = transmilenioRepository.findById(transmilenio.getId()).get();
        try{
            transmilenio2.setPlaca(transmilenio.getPlaca());
            transmilenio2.setModelo(transmilenio.getModelo());
            transmilenio2.setConductores(transmilenio.getConductores());
            transmilenio2.setRutas(transmilenio.getRutas());
            transmilenioRepository.save(transmilenio2);
            return transmilenio2;
        }catch(Exception e){
            return null;
        }
    }
}
