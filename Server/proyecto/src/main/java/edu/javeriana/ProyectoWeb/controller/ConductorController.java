package edu.javeriana.ProyectoWeb.controller;

import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        boolean comprobante = false;
        for(Conductor cond: conductorService.getConductores()){
            if(cond.getCedula() == conductor.getCedula()){
                comprobante = true;
                break;
            }
        }
        if(!comprobante){
            conductorService.addConductor(conductor);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public Conductor deleteConductor(@PathVariable ("id") Long id){
        Conductor aux = conductorService.getConductor(id);
        try{
            conductorService.removeConductor(id);
        }catch(Exception exception){
            return null;
        }
        return aux;
    }
    
    @PutMapping(value = "/update")
    public Conductor updateConductor(@RequestBody Conductor conductor){
         Conductor aux = conductorService.getConductor(conductor.getId());
         if(aux == null){
            return null;
         }else{
            conductorService.updateConductor(conductor);
            return conductorService.getConductor(conductor.getId());
         }
    }
}

