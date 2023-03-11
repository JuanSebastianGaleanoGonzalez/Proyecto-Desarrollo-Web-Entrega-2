package edu.javeriana.ProyectoWeb.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter @Setter @ToString @EqualsAndHashCode
public class Horario {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "horaInicio")
    private int horaInicio;
    @Column(name = "horaFinal")
    private int horaFinal;
    @Column (name = "diaSemana")
    private String diaSemana;

    @ManyToOne
    private Ruta ruta;
    public Horario(){};

    public Horario(int horaInit, int horaEnd, String dia){
        this.horaInicio = horaInit;
        this.horaFinal = horaEnd;
        this.diaSemana = dia; 
    };

}
