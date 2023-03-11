package edu.javeriana.ProyectoWeb.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ruta")
@Getter @Setter @ToString @EqualsAndHashCode
public class Ruta {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @OneToMany(mappedBy = "ruta")
    List<Horario> listaHorarios = new ArrayList<>();

    @ManyToMany
    private List<Estacion> estaciones = new ArrayList<>();

    @ManyToMany(mappedBy = "rutasAsignadas")
    List<Transmilenio> listaTransmilenios = new ArrayList<>();
    public Ruta(){};

    public Ruta(String codigo1){
        this.codigo = codigo1;
    }
}
