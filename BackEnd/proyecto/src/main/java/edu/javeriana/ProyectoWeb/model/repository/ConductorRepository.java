package edu.javeriana.ProyectoWeb.model.repository;

import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Long> {
    Optional<Conductor> findFirstBy();

    List<Conductor> findByCedula(int cedula);

}
