package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.entity.Horario;
import edu.javeriana.ProyectoWeb.model.repository.HorarioRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> getHorarios(){
        return (List<Horario>) horarioRepository.findAll();
    }

    public Horario getHorario(Long id){
        try{
            return horarioRepository.findById(id).orElseThrow();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public void addHorario(Horario horario){
        horarioRepository.save(horario);
    }

    public void removeHorario(Long id){
        horarioRepository.deleteById(id);
    }
}
