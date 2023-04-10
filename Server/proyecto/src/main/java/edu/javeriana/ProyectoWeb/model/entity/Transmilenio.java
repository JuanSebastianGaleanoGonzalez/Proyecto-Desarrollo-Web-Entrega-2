package edu.javeriana.ProyectoWeb.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "placa")
    private String placa;
    @Column(name = "modelo")
    private String modelo;

    @ManyToMany
    private List<Ruta> rutas = new ArrayList<>();

    @ManyToMany(mappedBy = "transmilenios")
    private List<Conductor> conductores = new ArrayList<>();
    public Transmilenio(){};

    public Transmilenio(String placa1, String modelo1){
        this.placa = placa1;
        this.modelo = modelo1;
    }
}
