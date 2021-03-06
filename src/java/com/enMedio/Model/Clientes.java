package com.enMedio.Model;
// Generated 18/07/2021 09:58:52 PM by Hibernate Tools 4.3.1

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Clientes generated by hbm2java
 */
@Entity
@Table(name = "clientes",
         catalog = "pruebaenmedio",
         uniqueConstraints = @UniqueConstraint(columnNames = "NIT")
)
public class Clientes implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private Integer nit;
    private Set ventases = new HashSet(0);
    private Set calificacions = new HashSet(0);

    public Clientes() {
    }

    public Clientes(Integer id, String nombre, Integer nit) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
    }

    public Clientes(Integer id, String nombre, Integer nit, Set ventases, Set calificacions) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.ventases = ventases;
        this.calificacions = calificacions;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "NIT", unique = true, nullable = false)
    public Integer getNit() {
        return this.nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientes")
    public Set getVentases() {
        return this.ventases;
    }

    public void setVentases(Set ventases) {
        this.ventases = ventases;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientes")
    public Set getCalificacions() {
        return this.calificacions;
    }

    public void setCalificacions(Set calificacions) {
        this.calificacions = calificacions;
    }

}
