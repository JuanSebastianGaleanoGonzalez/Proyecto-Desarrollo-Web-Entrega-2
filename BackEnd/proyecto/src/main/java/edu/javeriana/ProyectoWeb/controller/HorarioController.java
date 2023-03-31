package edu.javeriana.ProyectoWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.javeriana.ProyectoWeb.model.entity.Horario;
import edu.javeriana.ProyectoWeb.model.service.HorarioService;

@RestController
@RequestMapping(value = "/horario")
public class    HorarioController {

    @Autowired
    HorarioService horarioService;

    @GetMapping(value = "/read")
    public List<Horario> getHorarios(){
        return horarioService.getHorarios();
    }

    @GetMapping(value = "/read/{id}")
    public Horario getHorario(@PathVariable ("id") Long id){
        return horarioService.getHorario(id);
    }

    @PostMapping(value = "/save")
    public void addHorario(@RequestBody Horario horario){
        horarioService.addHorario(horario);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeHorario(@PathVariable ("id") Long id){
        horarioService.removeHorario(id);
    }
    
}
