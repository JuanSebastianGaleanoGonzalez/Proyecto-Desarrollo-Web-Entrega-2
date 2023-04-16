package edu.javeriana.ProyectoWeb.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "conductor_transmilenio")
@Getter @Setter @ToString @EqualsAndHashCode
public class ConductorTransmilenio {

    @Id
    @Column(name = "conductor_id")
    private Long conductorId;
   
    @Column(name = "transmilenio_id")
    private long transmilenioId;

    public ConductorTransmilenio(){};

}
