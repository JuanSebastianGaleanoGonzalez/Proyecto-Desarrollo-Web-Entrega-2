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

    public List<Conductor> getConductores() {
        try {
            return (List<Conductor>) conductorRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Conductor getConductor(long id) {
        try {
            return conductorRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    public Conductor addConductor(Conductor conductor) {
        try {
            conductorRepository.save(conductor);
            return conductor;
        } catch (Exception e) {
            return null;
        }
    }

    public Conductor removeConductor(long id) {
        Conductor conductor = conductorRepository.findById(id).get();
        try {
            conductorRepository.deleteById(id);
            return conductor;
        } catch (Exception e) {
            // Print trace
            return null;
        }
    }

    public Conductor updateConductor(Conductor conductor) {
        Conductor conductor2 = conductorRepository.findById(conductor.getId()).get();
        try {
            conductor2.setCedula(conductor.getCedula());
            conductor2.setNombre(conductor.getNombre());
            conductor2.setDireccion(conductor.getDireccion());
            conductor2.setTelefono(conductor.getTelefono());
            conductor2.setTransmilenios(conductor.getTransmilenios());
            conductorRepository.save(conductor2);
            return conductor2;
        } catch (Exception e) {
            return null;
        }
    }
}
