package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.Ruta;
import edu.javeriana.ProyectoWeb.model.repository.RutaRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> getRutas(){
        return (List<Ruta>) rutaRepository.findAll();
    }

    public Ruta getRuta(Long id){
        try{
            return rutaRepository.findById(id).orElseThrow();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public void addRuta(Ruta ruta){
        rutaRepository.save(ruta);
    }

    public void removeRuta(Long id){
        rutaRepository.deleteById(id);
    }

    public void updateRuta(Ruta ruta){
        Ruta ruta2 = rutaRepository.findById(ruta.getId()).get();
        ruta2.setCodigo(ruta.getCodigo());
        ruta2.setNombre(ruta.getNombre());
        rutaRepository.save(ruta2);
    }
}
