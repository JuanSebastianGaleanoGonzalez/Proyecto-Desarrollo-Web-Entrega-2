package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.entity.Transmilenio;
import edu.javeriana.ProyectoWeb.model.repository.TransmilenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrasmilenioService {

    @Autowired
    private TransmilenioRepository transmilenioRepository;

    public void eliminarTransmilenio(Transmilenio transmilenio){
        transmilenioRepository.delete(transmilenio);
    }

    public Transmilenio buscarTransmilenio(Long id){
        return transmilenioRepository.findById(id).orElseThrow();
    }

    public List<Transmilenio> listarTransmilenios(){
        return (List<Transmilenio>) transmilenioRepository.findAll();
    }

    public Conductor buscarConductor(Long id1, int id2){
        return transmilenioRepository.findById(id1).orElseThrow().getConductoresAsignados().get(id2);
    }
}
