package edu.javeriana.ProyectoWeb.controller;


import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.service.ConductorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping("/conductor")
public class ConductorController {

    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    ConductorService conductorService;

    @GetMapping("/list")
    public String listarConductores(Model model){
        model.addAttribute("conductores", conductorService.listarConductores());
        return "conductor-list";
    }

    @GetMapping("/view/{idConductor}")
    String verPersona(Model model, @PathVariable("idConductor") Long id) {
        Conductor conductor = conductorService.buscarConductor(id);
        model.addAttribute("conductor", conductor);
        return "conductor-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarPersona(Model model, @PathVariable Long id) {
        Conductor conductor = conductorService.buscarConductor(id);
        model.addAttribute("conductor", conductor);
        return "conductor-edit";
    }


    @PostMapping(value = "/save")
    public String guardarPersona(@Valid Conductor conductor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "person-edit";
        }
        conductorService.guardarConductor(conductor);
        return "redirect:/conductor/list";
    }

    @GetMapping("/search")
    public String listConductores(@RequestParam(required = false) String searchText, Model model) {
        List<Conductor> conductores;
        if (searchText == null || searchText.trim().equals("")) {
            log.info("No hay texto de búsqueda. Retornando todo");
            conductores = conductorService.listarConductores();
        } else {
            log.info("Buscando personas cuyo apellido comienza con {}", searchText);
            conductores = conductorService.buscarConductorCedula(Integer.parseInt(searchText));
        }
        model.addAttribute("conductores", conductores);
        return "conductor-search";
    }

    @GetMapping("/delete/{id}")
    public String eliminarConductor(Model model, @PathVariable Long id){
        Conductor conductorEliminar = conductorService.buscarConductor(id);
        conductorService.eliminarConductor(conductorEliminar);
        model.addAttribute("conductor", new Conductor());
        model.addAttribute("conductores", conductorService.listarConductores());
        return "conductor-list";
    }
}
