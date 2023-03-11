package edu.javeriana.ProyectoWeb.controller;

import edu.javeriana.ProyectoWeb.model.service.TrasmilenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transmilenio")
public class TransmilenioController {

    @Autowired
    TrasmilenioService trasmilenioService;
/*
    @GetMapping("/delete/{idTransmilenio}/{idConductor}")
    public String eliminarTransmilenio(Model model, @PathVariable("idTransmilenio") Long id, @PathVariable("idConductor") Long id2){
        Transmilenio transmilenioEliminar = trasmilenioService.buscarTransmilenio(id);
        trasmilenioService.eliminarTransmilenio(transmilenioEliminar);
        int idaux = Math.toIntExact(id2);
        model.addAttribute("conductor", trasmilenioService.buscarConductor(id, idaux));
        return "conductor-view";
    }*/
}
