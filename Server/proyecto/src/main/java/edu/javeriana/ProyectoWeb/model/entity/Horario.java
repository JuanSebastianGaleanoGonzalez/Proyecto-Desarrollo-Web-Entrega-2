package edu.javeriana.ProyectoWeb.model.entity;

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
@Table
@Getter @Setter @ToString @EqualsAndHashCode
public class Horario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "horaInicio")
    private int horaInicio;
    @Column(name = "horaFinal")
    private int horaFinal;
    @Column (name = "diaSemana")
    private String diaSemana;

    @ManyToMany(mappedBy = "horarios")
    private List<Ruta> rutas;

    public Horario(){};

    public Horario(int horaInit, int horaEnd, String dia){
        this.horaInicio = horaInit;
        this.horaFinal = horaEnd;
        this.diaSemana = dia; 
    };

}
