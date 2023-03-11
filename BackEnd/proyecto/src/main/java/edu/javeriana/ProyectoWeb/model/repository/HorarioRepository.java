package edu.javeriana.ProyectoWeb.model.repository;

import edu.javeriana.ProyectoWeb.model.entity.Horario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Long> {
}
