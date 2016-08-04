package com.sgd.hermes.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dependencia")

public class Dependencia implements Serializable {

    @Column(name = "depen_consecutivo_interno")
    @Basic
    private long consecutivoInterno;

    @Column(name = "depen_codigo")
    @Basic
    private String codigo;

    @Column(name = "depen_id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "depen_id")
    private Long id;

    @Column(name = "depen_consecutivo_externo")
    @Basic
    private long consecutivoExterno;

    @ManyToOne(targetEntity = Tercero.class)
    private Tercero jefe;

    @ManyToOne(targetEntity = Empresa.class)
    private Empresa empresa;

    @Column(name = "depen_nombre")
    @Basic
    private String nombre;

    public Dependencia() {

    }

    public long getConsecutivoInterno() {
        return this.consecutivoInterno;
    }

    public void setConsecutivoInterno(long consecutivoInterno) {
        this.consecutivoInterno = consecutivoInterno;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getConsecutivoExterno() {
        return this.consecutivoExterno;
    }

    public void setConsecutivoExterno(long consecutivoExterno) {
        this.consecutivoExterno = consecutivoExterno;
    }

    public Tercero getJefe() {
        return this.jefe;
    }

    public void setJefe(Tercero jefe) {
        this.jefe = jefe;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
