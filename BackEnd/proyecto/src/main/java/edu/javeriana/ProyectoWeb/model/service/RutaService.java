package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;
}
