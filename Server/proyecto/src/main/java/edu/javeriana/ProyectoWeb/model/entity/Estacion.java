package edu.javeriana.ProyectoWeb.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "estaciones", fetch = FetchType.LAZY)
    List<Ruta> listaRutas = new ArrayList<>();
    public Estacion(){};

    public Estacion(String name){
        this.nombre = name;
    }
}
