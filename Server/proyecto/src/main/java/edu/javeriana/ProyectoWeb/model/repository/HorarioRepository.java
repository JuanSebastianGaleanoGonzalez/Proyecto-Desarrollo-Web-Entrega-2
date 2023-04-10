package edu.javeriana.ProyectoWeb.model.repository;

import edu.javeriana.ProyectoWeb.model.entity.Horario;
import org.springframework.data.repository.CrudRepository;

public interface HorarioRepository extends CrudRepository<Horario, Long> {
    Horario findById(long id);
}
