package edu.javeriana.ProyectoWeb.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cedula")
    private int cedula;
    @Column(name = "telefono")
    private long telefono;
    @Column(name = "direccion")
    private String direccion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "conductor_transmilenio",
        joinColumns = {
            @JoinColumn(
                name = "conductor_id", 
                referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "transmilenio_id", 
                referencedColumnName = "id")
        }
    )
    private List<Transmilenio> transmilenios = new ArrayList<>();

    public Conductor(){};

    public Conductor(String nombre1, int cedula1, long telefono1, String direccion1){
        this.nombre = nombre1;
        this.cedula = cedula1;
        this.telefono = telefono1;
        this.direccion = direccion1;
    }
}
