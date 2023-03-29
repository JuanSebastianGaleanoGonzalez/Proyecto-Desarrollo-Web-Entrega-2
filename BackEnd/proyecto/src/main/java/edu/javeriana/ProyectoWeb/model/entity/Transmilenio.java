package edu.javeriana.ProyectoWeb.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "transmilenio")
@Getter @Setter @ToString @EqualsAndHashCode
public class Transmilenio {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "placa")
    private String placa;
    @Column(name = "modelo")
    private String modelo;

    @ManyToMany
    private List<Ruta> rutasAsignadas = new ArrayList<>();

    @ManyToMany(mappedBy = "listadoBuses")
    private List<Conductor> conductoresAsignados = new ArrayList<>();
    public Transmilenio(){};

    public Transmilenio(String placa1, String modelo1){
        this.placa = placa1;
        this.modelo = modelo1;
    }
}
