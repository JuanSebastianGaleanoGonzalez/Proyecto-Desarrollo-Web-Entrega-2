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

import edu.javeriana.ProyectoWeb.model.entity.Estacion;
import edu.javeriana.ProyectoWeb.model.service.EstacionService;

@RestController
@RequestMapping(value = "/estacion")
public class EstacionController {
    
    @Autowired
    EstacionService estacionService;

    @GetMapping(value = "/read")
    public List<Estacion> getEstaciones(){
        return estacionService.getEstaciones();
    }

    @GetMapping(value = "/read/{id}")
    public Estacion getEstacion(@PathVariable ("id") Long id){
        return estacionService.getEstacion(id);
    }

    @PostMapping(value = "/save")
    public void addEstacion(@RequestBody Estacion estacion){
        estacionService.addEstacion(estacion);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeEstacion(@PathVariable ("id") Long id){
        estacionService.removeEstacion(id);
    }
}
