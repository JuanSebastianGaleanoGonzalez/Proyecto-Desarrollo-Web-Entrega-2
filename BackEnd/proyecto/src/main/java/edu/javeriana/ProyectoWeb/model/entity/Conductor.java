package edu.javeriana.ProyectoWeb.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "conductor")
@Getter @Setter @ToString @EqualsAndHashCode
public class Conductor {

    @Id @GeneratedValue
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cedula")
    private int cedula;
    @Column(name = "telefono")
    private long telefono;
    @Column(name = "direccion")
    private String direccion;

    @ManyToMany
    private List<Transmilenio> listadoBuses = new ArrayList<>();

    public Conductor(){};

    public Conductor(String nombre1, int cedula1, long telefono1, String direccion1){
        this.nombre = nombre1;
        this.cedula = cedula1;
        this.telefono = telefono1;
        this.direccion = direccion1;
    }
}
