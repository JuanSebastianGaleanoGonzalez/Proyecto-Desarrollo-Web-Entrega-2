package edu.javeriana.ProyectoWeb.model.repository;


import edu.javeriana.ProyectoWeb.model.entity.Ruta;
import org.springframework.data.repository.CrudRepository;

public interface RutaRepository extends CrudRepository<Ruta, Long> {
    Ruta findById(long id);
}
