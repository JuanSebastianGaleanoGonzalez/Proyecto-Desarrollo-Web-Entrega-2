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
@Table(name = "ruta")
@Getter @Setter @ToString @EqualsAndHashCode
public class Ruta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @ManyToMany
    List<Horario> horarios = new ArrayList<>();

    @ManyToMany
    private List<Estacion> estaciones = new ArrayList<>();

    @ManyToMany(mappedBy = "rutas")
    List<Transmilenio> listaTransmilenios = new ArrayList<>();
    public Ruta(){};

    public Ruta(String codigo1){
        this.codigo = codigo1;
    }
}
