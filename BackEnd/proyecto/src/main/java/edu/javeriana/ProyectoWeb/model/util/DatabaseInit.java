package edu.javeriana.ProyectoWeb.model.util;

import edu.javeriana.ProyectoWeb.model.entity.*;
import edu.javeriana.ProyectoWeb.model.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    ConductorRepository conductorRepository;

    @Autowired
    TransmilenioRepository transmilenioRepository;

    @Autowired
    RutaRepository rutaRepository;

    @Autowired
    EstacionRepository estacionRepository;

    @Autowired
    HorarioRepository horarioRepository;

    @Override @Transactional
    public void run(ApplicationArguments args) throws Exception {
        conductorRepository.save(new Conductor("Sebastian Galeano", 123456, 890123, "Cra 5 Bis #9-36"));
        conductorRepository.save(new Conductor("Anderson Alvarado", 234567, 901234, "Cra 50 #100-12"));
        conductorRepository.save(new Conductor("Daniel Florido", 345678, 123456, "Cra 7 #200-80"));
        conductorRepository.save(new Conductor("Jaime Pavlich", 456789, 234567, "Cra 164 #15-62"));
        conductorRepository.save(new Conductor("Daniel Florido", 567890, 345678, "Cra 150 #50-44"));
        conductorRepository.save(new Conductor("Pepe Veraz", 678901, 456789, "Cra 20 #56-44"));
        conductorRepository.save(new Conductor("Speedy Gonzalez", 789012, 567890, "Calle 90 #22-44"));
        conductorRepository.save(new Conductor("El Pajaro Loco", 890123, 678901, "Calle 150 #44-44"));
        conductorRepository.save(new Conductor("Bugs Bunny", 901234, 789012, "Calle 13 #99-44"));
        conductorRepository.save(new Conductor("Perry el Ornitorrinco", 123456, 890123, "Calle 78 #45-44"));

        transmilenioRepository.save(new Transmilenio("ABC 123", "2001"));
        transmilenioRepository.save(new Transmilenio("DEF 234", "2005"));
        transmilenioRepository.save(new Transmilenio("GHI 345", "2010"));
        transmilenioRepository.save(new Transmilenio("JKL 456", "2015"));
        transmilenioRepository.save(new Transmilenio("MNÑ 567", "2004"));
        transmilenioRepository.save(new Transmilenio("OPQ 678", "2006"));
        transmilenioRepository.save(new Transmilenio("RST 789", "2020"));
        transmilenioRepository.save(new Transmilenio("UVW 890", "2023"));
        transmilenioRepository.save(new Transmilenio("XYZ 901", "2005"));
        transmilenioRepository.save(new Transmilenio("ABC 012", "2002"));

        rutaRepository.save(new Ruta("1"));
        rutaRepository.save(new Ruta("2"));
        rutaRepository.save(new Ruta("3"));
        rutaRepository.save(new Ruta("4"));
        rutaRepository.save(new Ruta("5"));
        rutaRepository.save(new Ruta("6"));
        rutaRepository.save(new Ruta("7"));
        rutaRepository.save(new Ruta("8"));
        rutaRepository.save(new Ruta("A52"));
        rutaRepository.save(new Ruta("A60"));
        rutaRepository.save(new Ruta("A61"));
        rutaRepository.save(new Ruta("B10"));
        rutaRepository.save(new Ruta("B11"));
        rutaRepository.save(new Ruta("B12"));
        rutaRepository.save(new Ruta("B13"));
        rutaRepository.save(new Ruta("B16"));
        rutaRepository.save(new Ruta("B18"));
        rutaRepository.save(new Ruta("B23"));
        rutaRepository.save(new Ruta("B26"));
        rutaRepository.save(new Ruta("B27"));
        rutaRepository.save(new Ruta("B28"));
        rutaRepository.save(new Ruta("B46"));
        rutaRepository.save(new Ruta("B50"));
        rutaRepository.save(new Ruta("B55"));
        rutaRepository.save(new Ruta("B71"));
        rutaRepository.save(new Ruta("B72"));
        rutaRepository.save(new Ruta("B74"));
        rutaRepository.save(new Ruta("B75"));
        rutaRepository.save(new Ruta("C15"));
        rutaRepository.save(new Ruta("C17"));
        rutaRepository.save(new Ruta("C19"));
        rutaRepository.save(new Ruta("C25"));

        estacionRepository.save(new Estacion("Guatoque - Veraguas"));
        estacionRepository.save(new Estacion("Tygua - San José (Lado Sur)"));
        estacionRepository.save(new Estacion("Tercer Milenio"));
        estacionRepository.save(new Estacion("Avenida Jiménez"));
        estacionRepository.save(new Estacion("Calle 19"));
        estacionRepository.save(new Estacion("Calle 22"));
        estacionRepository.save(new Estacion("Calle 26"));
        estacionRepository.save(new Estacion("Calle 34"));
        estacionRepository.save(new Estacion("Avenida 39"));
        estacionRepository.save(new Estacion("Calle 45"));
        estacionRepository.save(new Estacion("Marly"));
        estacionRepository.save(new Estacion("Calle 57"));
        estacionRepository.save(new Estacion("Calle 63"));
        estacionRepository.save(new Estacion("Flores"));
        estacionRepository.save(new Estacion("Calle 72"));
        estacionRepository.save(new Estacion("Calle 76"));
        estacionRepository.save(new Estacion("Héroes"));
        estacionRepository.save(new Estacion("Calle 85"));
        estacionRepository.save(new Estacion("Virrey"));
        estacionRepository.save(new Estacion("Calle 100"));
        estacionRepository.save(new Estacion("Calle 106"));
        estacionRepository.save(new Estacion("Pepe Sierra"));
        estacionRepository.save(new Estacion("Pepe Sierra"));
        estacionRepository.save(new Estacion("Prado"));
        estacionRepository.save(new Estacion("Alcalá"));
        estacionRepository.save(new Estacion("Calle 142 (Lado Sur)"));
        estacionRepository.save(new Estacion("Calle 146"));
        estacionRepository.save(new Estacion("Mazurén (Lado Sur)"));
        estacionRepository.save(new Estacion("Calle 161 (Lado Sur)"));
        estacionRepository.save(new Estacion("Toberín (Lado Sur)"));
        estacionRepository.save(new Estacion("Portal Del Norte"));
        estacionRepository.save(new Estacion("Calle 187"));
        estacionRepository.save(new Estacion("Terminal"));

        horarioRepository.save(new Horario(6,12, DiaSemana.Lunes.toString()));
        horarioRepository.save(new Horario(12,18, DiaSemana.Lunes.toString()));
        horarioRepository.save(new Horario(18,24, DiaSemana.Lunes.toString()));
        horarioRepository.save(new Horario(6,12, DiaSemana.Martes.toString()));
        horarioRepository.save(new Horario(12,18, DiaSemana.Martes.toString()));
        horarioRepository.save(new Horario(18,24, DiaSemana.Martes.toString()));
        horarioRepository.save(new Horario(6,12, DiaSemana.Miercoles.toString()));
        horarioRepository.save(new Horario(12,18, DiaSemana.Miercoles.toString()));
        horarioRepository.save(new Horario(18,24, DiaSemana.Miercoles.toString()));
        horarioRepository.save(new Horario(6,12, DiaSemana.Jueves.toString()));
        horarioRepository.save(new Horario(12,18, DiaSemana.Jueves.toString()));
        horarioRepository.save(new Horario(18,24, DiaSemana.Jueves.toString()));
        horarioRepository.save(new Horario(6,12, DiaSemana.Viernes.toString()));
        horarioRepository.save(new Horario(12,18, DiaSemana.Viernes.toString()));
        horarioRepository.save(new Horario(18,24, DiaSemana.Viernes.toString()));
        horarioRepository.save(new Horario(6,12, DiaSemana.Sabado.toString()));
        horarioRepository.save(new Horario(12,18, DiaSemana.Sabado.toString()));
        horarioRepository.save(new Horario(18,24, DiaSemana.Sabado.toString()));
        horarioRepository.save(new Horario(6,12, DiaSemana.Domingo.toString()));
        horarioRepository.save(new Horario(12,18, DiaSemana.Domingo.toString()));
        horarioRepository.save(new Horario(18,24, DiaSemana.Domingo.toString()));

        for(Conductor conductor: conductorRepository.findAll()){
            long numero = (long)(Math.random()*(transmilenioRepository.count() + 1));
            int cantidadBuses = (int)(Math.random()*(transmilenioRepository.count() + 1));
            for(int iterador = 0; iterador < cantidadBuses; iterador++){
                Transmilenio aux = transmilenioRepository.findById(numero);
                if(aux != null && !conductor.getListadoBuses().contains(aux)){
                    while(conductor.getListadoBuses().contains(aux)){
                        aux = transmilenioRepository.findById(numero);
                    }
                    conductor.getListadoBuses().add(aux);
                }
                numero = (long)(Math.random()*(transmilenioRepository.count() + 1));
            }
        }
    }
}
