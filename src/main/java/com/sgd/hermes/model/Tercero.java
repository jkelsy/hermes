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
@Table(name = "tercero")

public class Tercero implements Serializable {

    @Column(name = "ter_apellido2")
    @Basic
    private String apellido2;

    @ManyToOne(targetEntity = TipoIdentificacion.class)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "ter_apellido1")
    @Basic
    private String apellido1;

    @Column(name = "ter_direccion")
    @Basic
    private String direccion;

    @Column(name = "ter_identificacion")
    @Basic
    private String identificacion;

    @Column(name = "ter_id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "ter_id")
    private Long id;

    @Column(name = "ter_telefono")
    @Basic
    private String telefono;

    @Column(name = "ter_email")
    @Basic
    private String email;

    @Column(name = "ter_nombres")
    @Basic
    private String nombres;

    public Tercero() {

    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
