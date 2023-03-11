package edu.javeriana.ProyectoWeb.model.repository;

import edu.javeriana.ProyectoWeb.model.entity.Transmilenio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmilenioRepository extends CrudRepository<Transmilenio, Long> {
    Transmilenio findById(long id);
}
