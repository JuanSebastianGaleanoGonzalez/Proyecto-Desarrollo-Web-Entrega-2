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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conductor other = (Conductor) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (cedula != other.cedula)
            return false;
        if (telefono != other.telefono)
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        if (transmilenios == null) {
            if (other.transmilenios != null)
                return false;
        } else if (!transmilenios.equals(other.transmilenios))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + cedula;
        result = prime * result + (int) (telefono ^ (telefono >>> 32));
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
        result = prime * result + ((transmilenios == null) ? 0 : transmilenios.hashCode());
        return result;
    }
}
