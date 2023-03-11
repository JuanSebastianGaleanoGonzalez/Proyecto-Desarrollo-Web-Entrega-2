package edu.javeriana.ProyectoWeb.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estacion")
@Getter @Setter @ ToString @EqualsAndHashCode
public class Estacion {

    @Id @GeneratedValue
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "estaciones")
    List<Ruta> listaRutas = new ArrayList<>();
    public Estacion(){};

    public Estacion(String name){
        this.nombre = name;
    }
}
