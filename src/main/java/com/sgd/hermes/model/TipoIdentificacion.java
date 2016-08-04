package com.sgd.hermes.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_identificacion")

public class TipoIdentificacion implements Serializable {

    @Column(name = "tpid_codigo")
    @Basic
    private String codigo;

    @Column(name = "tpid_abreviatura")
    @Basic
    private String abreviatura;

    @Column(name = "tpid_id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "tpid_id")
    private Long id;

    @Column(name = "tpid_nombre")
    @Basic
    private String nombre;

    public TipoIdentificacion() {

    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}