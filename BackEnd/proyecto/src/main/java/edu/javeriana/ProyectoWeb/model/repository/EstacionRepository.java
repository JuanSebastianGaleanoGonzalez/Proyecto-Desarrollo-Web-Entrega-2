package edu.javeriana.ProyectoWeb.model.repository;

import edu.javeriana.ProyectoWeb.model.entity.Estacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionRepository extends CrudRepository<Estacion, Long> {

}
