package edu.javeriana.ProyectoWeb.controller;

import edu.javeriana.ProyectoWeb.model.entity.Transmilenio;
import edu.javeriana.ProyectoWeb.model.service.TransmilenioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transmilenio")
public class TransmilenioController {

    @Autowired
    TransmilenioService transmilenioService;

    @GetMapping(value = "/read")
    public List<Transmilenio> getTransmilenios(){
        return transmilenioService.getTransmilenios();
    }

    @GetMapping(value = "/read/{id}")
    public Transmilenio getTransmilenio(@PathVariable ("id") Long id){
        return transmilenioService.getTransmilenio(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Transmilenio removeTransmilenio(@PathVariable ("id") Long id){
        return transmilenioService.removeTransmilenio(id);
    }

    @PutMapping(value = "/update")
    public Transmilenio updateTransmilenio(@RequestBody Transmilenio transmilenio){
        return transmilenioService.updateTransmilenio(transmilenio);
    }

    @PostMapping(value = "/create")
    public Transmilenio addTransmilenio(@RequestBody Transmilenio transmilenio){
        boolean comprobante = false;
        for(Transmilenio transmilenio2: transmilenioService.getTransmilenios()){
            if(transmilenio2.getPlaca() == transmilenio.getPlaca()){
                comprobante = true;
                break;
            }
        }
        if(!comprobante){
            return transmilenioService.addTransmilenio(transmilenio);
        }else{
            return null;
        }
    }
}
