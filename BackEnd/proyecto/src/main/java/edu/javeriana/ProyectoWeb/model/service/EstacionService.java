package edu.javeriana.ProyectoWeb.model.service;

import edu.javeriana.ProyectoWeb.model.repository.EstacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionService {
    @Autowired
    private EstacionRepository estacionRepository;
}
