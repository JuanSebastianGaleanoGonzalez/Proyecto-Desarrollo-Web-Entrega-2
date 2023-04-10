package edu.javeriana.ProyectoWeb.model.repository;

import edu.javeriana.ProyectoWeb.model.entity.Estacion;
import org.springframework.data.repository.CrudRepository;

public interface EstacionRepository extends CrudRepository<Estacion, Long> {
    Estacion findById(long id);
}
