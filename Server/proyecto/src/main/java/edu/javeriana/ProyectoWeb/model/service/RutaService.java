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

    public Ruta addRuta(Ruta ruta){
        try{
            rutaRepository.save(ruta);
            return ruta;
        }catch(Exception e){
            return null;
        }
    }

    public Ruta removeRuta(Long id){
        Ruta ruta = rutaRepository.findById(id).get();
        Ruta rutaAux = new Ruta(ruta.getCodigo(), ruta.getNombre());
        try{
            rutaRepository.deleteById(id);
            return rutaAux;
        }catch(Exception e){
            return null;
        }

    }

    public Ruta updateRuta(Ruta ruta){
        try{
            Ruta ruta2 = rutaRepository.findById(ruta.getId()).get();
            ruta2.setCodigo(ruta.getCodigo());
            ruta2.setNombre(ruta.getNombre());
            ruta2.setEstaciones(ruta.getEstaciones());
            ruta2.setHorarios(ruta.getHorarios());
            rutaRepository.save(ruta2);
            return ruta2;
        }catch(Exception e){
            return null;
        }

    }
}
