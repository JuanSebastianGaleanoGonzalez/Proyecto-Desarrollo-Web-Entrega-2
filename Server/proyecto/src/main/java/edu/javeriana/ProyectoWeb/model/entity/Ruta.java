package edu.javeriana.ProyectoWeb.model.entity;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ruta")
@Getter @Setter @ToString @EqualsAndHashCode
public class Ruta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
        name = "ruta_horario",
        joinColumns = {
            @JoinColumn(
                name = "ruta_id",
                referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "horario_id",
                referencedColumnName = "id"
            )
        }
    )
    List<Horario> horarios = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
        name = "ruta_estacion",
        joinColumns = {
            @JoinColumn(
                name = "ruta_id",
                referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "estacion_id",
                referencedColumnName = "id"
            )
        }
    )
    private List<Estacion> estaciones = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "rutas", fetch = FetchType.LAZY)
    List<Transmilenio> listaTransmilenios = new ArrayList<>();
    public Ruta(){};

    public Ruta(String codigo1, String nombre1){
        this.codigo = codigo1;
        this.nombre = nombre1;
    }
}
