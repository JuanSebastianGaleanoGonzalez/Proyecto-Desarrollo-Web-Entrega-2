package edu.javeriana.ProyectoWeb.model.repository;


import edu.javeriana.ProyectoWeb.model.entity.Ruta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends CrudRepository<Ruta, Long> {
}
