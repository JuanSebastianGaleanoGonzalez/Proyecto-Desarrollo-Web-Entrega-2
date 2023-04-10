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
import edu.javeriana.ProyectoWeb.model.service.RutaService;
import edu.javeriana.ProyectoWeb.model.entity.Ruta;
@RestController
@RequestMapping(value = "/ruta")
public class RutaController {

    @Autowired
    RutaService rutaService;

    @GetMapping(value = "/read")
    public List<Ruta> getRutas(){
        return rutaService.getRutas();
    }

    @GetMapping(value = "/read/{id}")
    public Ruta getRuta(@PathVariable ("id") Long id){
        return rutaService.getRuta(id);
    }

    @PostMapping(value = "/save")
    public void addRuta(@RequestBody Ruta ruta){
        rutaService.addRuta(ruta);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void removeRuta(@PathVariable ("id") Long id){
       rutaService.removeRuta(id); 
    }
}
