package edu.javeriana.ProyectoWeb.model.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.entity.Estacion;
import edu.javeriana.ProyectoWeb.model.entity.Horario;
import edu.javeriana.ProyectoWeb.model.entity.Ruta;
import edu.javeriana.ProyectoWeb.model.entity.Transmilenio;
import edu.javeriana.ProyectoWeb.model.repository.ConductorRepository;
import edu.javeriana.ProyectoWeb.model.repository.EstacionRepository;
import edu.javeriana.ProyectoWeb.model.repository.HorarioRepository;
import edu.javeriana.ProyectoWeb.model.repository.RutaRepository;
import edu.javeriana.ProyectoWeb.model.repository.TransmilenioRepository;

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

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        conductorRepository.save(new Conductor("Sebastian Galeano", 123456, 890123, "Cra 5 Bis #9-36"));
        conductorRepository.save(new Conductor("Anderson Alvarado", 234567, 901234, "Cra 50 #100-12"));
        conductorRepository.save(new Conductor("Daniel Florido", 345678, 123456, "Cra 7 #200-80"));
        conductorRepository.save(new Conductor("Jaime Pavlich", 456789, 234567, "Cra 164 #15-62"));
        conductorRepository.save(new Conductor("Zuluaga Pecueca", 567890, 345678, "Cra 150 #50-44"));
        conductorRepository.save(new Conductor("Pepe Veraz", 678901, 456789, "Cra 20 #56-44"));
        conductorRepository.save(new Conductor("Speedy Gonzalez", 789012, 567890, "Calle 90 #22-44"));

        transmilenioRepository.save(new Transmilenio("KLP287", "2011", DiaSemana.Lunes.toString()));
        transmilenioRepository.save(new Transmilenio("MNO825", "2012", DiaSemana.Martes.toString()));
        transmilenioRepository.save(new Transmilenio("PQR490", "2013", DiaSemana.Miercoles.toString()));
        transmilenioRepository.save(new Transmilenio("ABC752", "2014", DiaSemana.Jueves.toString()));
        transmilenioRepository.save(new Transmilenio("DEF943", "2015", DiaSemana.Viernes.toString()));
        transmilenioRepository.save(new Transmilenio("GHI631", "2016", DiaSemana.Sabado.toString()));
        transmilenioRepository.save(new Transmilenio("JKL205", "2017", DiaSemana.Domingo.toString()));
        transmilenioRepository.save(new Transmilenio("STU180", "2018", DiaSemana.Lunes.toString()));
        transmilenioRepository.save(new Transmilenio("VWX305", "2019", DiaSemana.Martes.toString()));
        transmilenioRepository.save(new Transmilenio("YZA491", "2020", DiaSemana.Miercoles.toString()));
        transmilenioRepository.save(new Transmilenio("BCD835", "2021", DiaSemana.Jueves.toString()));
        transmilenioRepository.save(new Transmilenio("EFG526", "2010", DiaSemana.Viernes.toString()));
        transmilenioRepository.save(new Transmilenio("HIJ921", "2011", DiaSemana.Sabado.toString()));
        transmilenioRepository.save(new Transmilenio("KLM587", "2012", DiaSemana.Domingo.toString()));
        transmilenioRepository.save(new Transmilenio("NOP418", "2013", DiaSemana.Lunes.toString()));

        rutaRepository.save(new Ruta("S42", "Chapinero"));
        rutaRepository.save(new Ruta("E59", "Usaquén"));
        rutaRepository.save(new Ruta("B13", "Santa Fe"));
        rutaRepository.save(new Ruta("A20", "La Candelaria"));
        rutaRepository.save(new Ruta("S77", "San Cristóbal"));
        rutaRepository.save(new Ruta("T61", "Usme"));
        rutaRepository.save(new Ruta("I84", "Tunjuelito"));
        rutaRepository.save(new Ruta("A84", "Bosa"));
        rutaRepository.save(new Ruta("N25", "Kennedy"));
        rutaRepository.save(new Ruta("G39", "Fontibón"));
        rutaRepository.save(new Ruta("A17", "Engativá"));
        rutaRepository.save(new Ruta("L98", "Suba"));
        rutaRepository.save(new Ruta("E89", "Barrios Unidos"));
        rutaRepository.save(new Ruta("A39", "Teusaquillo"));
        rutaRepository.save(new Ruta("N11", "Los Mártires"));
        rutaRepository.save(new Ruta("O58", "Antonio Nariño"));
        rutaRepository.save(new Ruta("S79", "Puente Aranda"));
        rutaRepository.save(new Ruta("E22", "Candelaria"));
        rutaRepository.save(new Ruta("B77", "Rafael Uribe Uribe"));
        rutaRepository.save(new Ruta("A72", "Ciudad Bolívar"));
        rutaRepository.save(new Ruta("N60", "Sumapaz"));
        rutaRepository.save(new Ruta("G54", "La Macarena"));
        rutaRepository.save(new Ruta("A68", "San José"));
        rutaRepository.save(new Ruta("L28", "Palermo"));
        rutaRepository.save(new Ruta("E77", "La Concordia"));
        rutaRepository.save(new Ruta("A53", "Chico"));
        rutaRepository.save(new Ruta("N83", "Paloquemao"));
        rutaRepository.save(new Ruta("O67", "Centro Internacional"));
        rutaRepository.save(new Ruta("S95", "La Merced"));
        rutaRepository.save(new Ruta("E32", "Galerías"));
        rutaRepository.save(new Ruta("B43", "Salitre"));
        rutaRepository.save(new Ruta("A87", "Modelia"));
        rutaRepository.save(new Ruta("N72", "El Dorado"));
        rutaRepository.save(new Ruta("G99", "La Perseverancia"));
        rutaRepository.save(new Ruta("A10", "Zona Rosa"));
        rutaRepository.save(new Ruta("L47", "La Soledad"));
        rutaRepository.save(new Ruta("E46", "Cedritos"));
        rutaRepository.save(new Ruta("A66", "La Castellana"));
        rutaRepository.save(new Ruta("N30", "Mazurén"));
        rutaRepository.save(new Ruta("O29", "Colina Campestre"));
        rutaRepository.save(new Ruta("S65", "Prado Veraniego"));
        rutaRepository.save(new Ruta("E27", "La Floresta"));

        estacionRepository.save(new Estacion("Calle 116"));
        estacionRepository.save(new Estacion("Avenida 68"));
        estacionRepository.save(new Estacion("Avenida Boyacá"));
        estacionRepository.save(new Estacion("Calle 63"));
        estacionRepository.save(new Estacion("Avenida Suba"));
        estacionRepository.save(new Estacion("Calle 100"));
        estacionRepository.save(new Estacion("Avenida Caracas"));
        estacionRepository.save(new Estacion("Calle 80"));
        estacionRepository.save(new Estacion("Avenida Villavicencio"));
        estacionRepository.save(new Estacion("Avenida Primero de Mayo"));
        estacionRepository.save(new Estacion("Carrera 7"));
        estacionRepository.save(new Estacion("Carrera 10"));
        estacionRepository.save(new Estacion("Carrera 13"));
        estacionRepository.save(new Estacion("Carrera 19"));
        estacionRepository.save(new Estacion("Carrera 22"));
        estacionRepository.save(new Estacion("Carrera 27"));
        estacionRepository.save(new Estacion("Carrera 30"));
        estacionRepository.save(new Estacion("Carrera 50"));
        estacionRepository.save(new Estacion("Carrera 68"));
        estacionRepository.save(new Estacion("Carrera 80"));
        estacionRepository.save(new Estacion("Avenida 19"));
        estacionRepository.save(new Estacion("Avenida 26"));
        estacionRepository.save(new Estacion("Avenida 30"));
        estacionRepository.save(new Estacion("Avenida 39"));
        estacionRepository.save(new Estacion("Avenida 45"));
        estacionRepository.save(new Estacion("Avenida 68 Sur"));
        estacionRepository.save(new Estacion("Avenida 68 Norte"));
        estacionRepository.save(new Estacion("Avenida 72"));
        estacionRepository.save(new Estacion("Avenida 80"));
        estacionRepository.save(new Estacion("Avenida 86"));
        estacionRepository.save(new Estacion("Calle 26"));
        estacionRepository.save(new Estacion("Calle 39"));
        estacionRepository.save(new Estacion("Calle 45"));
        estacionRepository.save(new Estacion("Calle 53"));
        estacionRepository.save(new Estacion("Calle 57"));
        estacionRepository.save(new Estacion("Calle 63 Sur"));
        estacionRepository.save(new Estacion("Calle 63 Norte"));
        estacionRepository.save(new Estacion("Calle 72"));
        estacionRepository.save(new Estacion("Calle 76"));
        estacionRepository.save(new Estacion("Calle 85"));
        estacionRepository.save(new Estacion("Calle 170"));
        estacionRepository.save(new Estacion("Calle 183"));
        estacionRepository.save(new Estacion("Calle 200"));
        estacionRepository.save(new Estacion("Calle 222"));
        estacionRepository.save(new Estacion("Calle 234"));
        estacionRepository.save(new Estacion("Carrera 1"));
        estacionRepository.save(new Estacion("Carrera 3"));
        estacionRepository.save(new Estacion("Carrera 5"));
        estacionRepository.save(new Estacion("Carrera 9"));
        estacionRepository.save(new Estacion("Carrera 11"));
        estacionRepository.save(new Estacion("Carrera 15"));
        estacionRepository.save(new Estacion("Carrera 17"));
        estacionRepository.save(new Estacion("Carrera 21"));
        estacionRepository.save(new Estacion("Carrera 24"));
        estacionRepository.save(new Estacion("Carrera 34"));
        estacionRepository.save(new Estacion("Carrera 40"));
        estacionRepository.save(new Estacion("Carrera 45"));
        estacionRepository.save(new Estacion("Carrera 50 Sur"));
        estacionRepository.save(new Estacion("Carrera 114"));
        estacionRepository.save(new Estacion("Carrera 126"));
        estacionRepository.save(new Estacion("Carrera 128"));
        estacionRepository.save(new Estacion("Carrera 131"));
        estacionRepository.save(new Estacion("Carrera 133"));
        estacionRepository.save(new Estacion("Carrera 138"));
        estacionRepository.save(new Estacion("Carrera 142"));
        estacionRepository.save(new Estacion("Carrera 147 Bis"));
        estacionRepository.save(new Estacion("Carrera 154"));
        estacionRepository.save(new Estacion("Carrera 161"));
        estacionRepository.save(new Estacion("Carrera 170 Bis"));
        estacionRepository.save(new Estacion("Carrera 174"));
        estacionRepository.save(new Estacion("Carrera 182"));
        estacionRepository.save(new Estacion("Carrera 192"));
        estacionRepository.save(new Estacion("Carrera 200 Bis"));
        estacionRepository.save(new Estacion("Carrera 208"));
        estacionRepository.save(new Estacion("Carrera 215"));
        estacionRepository.save(new Estacion("Carrera 222 Bis"));
        estacionRepository.save(new Estacion("Carrera 226"));
        estacionRepository.save(new Estacion("Carrera 232"));
        estacionRepository.save(new Estacion("Carrera 238"));
        estacionRepository.save(new Estacion("Carrera 244"));
        estacionRepository.save(new Estacion("Carrera 252"));
        estacionRepository.save(new Estacion("Carrera 258"));
        estacionRepository.save(new Estacion("Carrera 266"));
        estacionRepository.save(new Estacion("Carrera 272"));
        estacionRepository.save(new Estacion("Carrera 276"));
        estacionRepository.save(new Estacion("Carrera 280"));
        estacionRepository.save(new Estacion("Carrera 286"));
        estacionRepository.save(new Estacion("Carrera 296"));

        horarioRepository.save(new Horario(6, 12, DiaSemana.Lunes.toString()));
        horarioRepository.save(new Horario(12, 18, DiaSemana.Lunes.toString()));
        horarioRepository.save(new Horario(18, 24, DiaSemana.Lunes.toString()));
        horarioRepository.save(new Horario(6, 12, DiaSemana.Martes.toString()));
        horarioRepository.save(new Horario(12, 18, DiaSemana.Martes.toString()));
        horarioRepository.save(new Horario(18, 24, DiaSemana.Martes.toString()));
        horarioRepository.save(new Horario(6, 12, DiaSemana.Miercoles.toString()));
        horarioRepository.save(new Horario(12, 18, DiaSemana.Miercoles.toString()));
        horarioRepository.save(new Horario(18, 24, DiaSemana.Miercoles.toString()));
        horarioRepository.save(new Horario(6, 12, DiaSemana.Jueves.toString()));
        horarioRepository.save(new Horario(12, 18, DiaSemana.Jueves.toString()));
        horarioRepository.save(new Horario(18, 24, DiaSemana.Jueves.toString()));
        horarioRepository.save(new Horario(6, 12, DiaSemana.Viernes.toString()));
        horarioRepository.save(new Horario(12, 18, DiaSemana.Viernes.toString()));
        horarioRepository.save(new Horario(18, 24, DiaSemana.Viernes.toString()));
        horarioRepository.save(new Horario(6, 12, DiaSemana.Sabado.toString()));
        horarioRepository.save(new Horario(12, 18, DiaSemana.Sabado.toString()));
        horarioRepository.save(new Horario(18, 24, DiaSemana.Sabado.toString()));
        horarioRepository.save(new Horario(6, 12, DiaSemana.Domingo.toString()));
        horarioRepository.save(new Horario(12, 18, DiaSemana.Domingo.toString()));
        horarioRepository.save(new Horario(18, 24, DiaSemana.Domingo.toString()));

        for (Ruta ruta : rutaRepository.findAll()) {
            long numero = (long) (Math.random() * (horarioRepository.count() + 1));
            // int cantidadHorarios = (int)(Math.random()*(horarioRepository.count() + 1));
            int cantidadHorarios = 12;
            for (int iterador = 0; iterador < cantidadHorarios; iterador++) {
                Horario aux = horarioRepository.findById((long) numero);
                if (aux != null && !ruta.getHorarios().contains(aux)) {
                    while (ruta.getHorarios().contains(aux)) {
                        aux = horarioRepository.findById((long) numero);
                    }
                    ruta.getHorarios().add(aux);
                }
                numero = (long) (Math.random() * (horarioRepository.count() + 1));
            }

        }

        for (Ruta ruta : rutaRepository.findAll()) {
            long numero = (long) (Math.random() * (estacionRepository.count() + 1));
            // int cantidadEstaciones = (int)(Math.random()*(estacionRepository.count() +
            // 1));
            int cantidadEstaciones = 20;
            for (int iterador = 0; iterador < cantidadEstaciones; iterador++) {
                Estacion aux = estacionRepository.findById((long) numero);
                if (aux != null && !ruta.getEstaciones().contains(aux)) {
                    while (ruta.getEstaciones().contains(aux)) {
                        aux = estacionRepository.findById((long) numero);
                    }
                    ruta.getEstaciones().add(aux);
                }
                numero = (long) (Math.random() * (estacionRepository.count() + 1));
            }
        }

        for (Transmilenio transmilenio : transmilenioRepository.findAll()) {
            // Numero de rutas por transmilenio.
            long numero = (long) (Math.random() * (rutaRepository.count() + 1));
            // int cantidadRutas = (int)(Math.random()*(estacionRepository.count() + 1));
            int cantidadRutas = 20;
            for (int iterador = 0; iterador < cantidadRutas; iterador++) {
                Ruta aux = rutaRepository.findById((long) numero);
                if (aux != null && !transmilenio.getRutas().contains(aux)) {
                    while (transmilenio.getRutas().contains(aux)) {
                        aux = rutaRepository.findById((long) numero);
                    }
                    transmilenio.getRutas().add(aux);
                }
                numero = (long) (Math.random() * (estacionRepository.count() + 1));
            }
        }

        for (Conductor conductor : conductorRepository.findAll()) {
            long numero = (long) (Math.random() * (transmilenioRepository.count() + 1));
            // int cantidadBuses = (int)(Math.random()*(transmilenioRepository.count() +
            // 1));
            int cantidadBuses = 14;
            for (int iterador = 0; iterador < cantidadBuses; iterador++) {
                Transmilenio aux = transmilenioRepository.findById((long) numero);
                if (aux != null && !conductor.getTransmilenios().contains(aux)) {
                    while (conductor.getTransmilenios().contains(aux)) {
                        aux = transmilenioRepository.findById((long) numero);
                    }
                    conductor.getTransmilenios().add(aux);
                }
                numero = (long) (Math.random() * (transmilenioRepository.count() + 1));
            }
        }

        conductorRepository.save(new Conductor("El Pajaro Loco", 890123, 678901, "Calle 150 #44-44"));
        conductorRepository.save(new Conductor("Bugs Bunny", 901234, 789012, "Calle 13 #99-44"));
        conductorRepository.save(new Conductor("Perry el Ornitorrinco", 123456, 890123, "Calle 78 #45-44"));

        rutaRepository.save(new Ruta("B96", "Normandía"));
        rutaRepository.save(new Ruta("A71", "El Tintal"));
        rutaRepository.save(new Ruta("N90", "La Estrella"));
        rutaRepository.save(new Ruta("G16", "Barrio Nuevo"));
        rutaRepository.save(new Ruta("A76", "Las Ferias"));
        rutaRepository.save(new Ruta("L55", "Madelena"));
        rutaRepository.save(new Ruta("E33", "Villa Mayor"));
        rutaRepository.save(new Ruta("A29", "La Serena"));

        transmilenioRepository.save(new Transmilenio("QRS295", "2014", DiaSemana.Martes.toString()));
        transmilenioRepository.save(new Transmilenio("TUV684", "2015", DiaSemana.Miercoles.toString()));
        transmilenioRepository.save(new Transmilenio("WXY727", "2016", DiaSemana.Jueves.toString()));
        transmilenioRepository.save(new Transmilenio("ZAB129", "2017", DiaSemana.Viernes.toString()));
        transmilenioRepository.save(new Transmilenio("CDE909", "2018", DiaSemana.Sabado.toString()));

    }
}
