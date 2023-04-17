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
@Table(name = "transmilenio")
@Getter @Setter @ToString @EqualsAndHashCode
public class Transmilenio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "placa")
    private String placa;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "dia")
    private String dia;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
        name = "transmilenio_ruta",
        joinColumns = {
            @JoinColumn(
                name = "transmilenio_id",
                referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "ruta_id",
                referencedColumnName = "id"
            )
        }
    )
    private List<Ruta> rutas = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "transmilenios", fetch = FetchType.LAZY)
    private List<Conductor> conductores = new ArrayList<>();

    public Transmilenio(){};
    
    public Transmilenio(String placA, String modelO, String dia){
        this.placa = placA;
        this.modelo = modelO;
        this.dia = dia;
    }
}
