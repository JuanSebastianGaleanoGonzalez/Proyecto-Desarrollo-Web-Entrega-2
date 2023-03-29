package edu.javeriana.ProyectoWeb.controller;

import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/conductor")
public class ConductorController {

    @Autowired
    ConductorService conductorService;

    @GetMapping(value = "/read")
    public List<Conductor> getConductores(){
        return conductorService.getConductores();
    }

    @GetMapping(value = "/read/{id}")
    public Conductor getConductor(@PathVariable ("id") Long id){
        return conductorService.getConductor(id);
    }

    @PostMapping(value = "/create")
    public void addConductor(@RequestBody Conductor conductor){
        conductorService.addConductor(conductor);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteConductor(@PathVariable ("id") Long id){
        conductorService.removeConductor(id);
    }
}

