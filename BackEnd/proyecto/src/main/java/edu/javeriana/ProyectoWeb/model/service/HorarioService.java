package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;
}
