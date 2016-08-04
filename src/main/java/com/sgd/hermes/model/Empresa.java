package com.sgd.hermes.model;

import java.io.Serializable;
import java.sql.Blob;
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
@Table(name = "empresa")

public class Empresa implements Serializable {

    @Column(name = "emp_radicado_salida")
    @Basic
    private String radicadoSalida;

    @Column(name = "emp_logo_fondo_carta")
    @Basic
    private String logoFondoCarta;

    @Column(name = "emp_archivo_ruta")
    @Basic
    private String archivoRuta;

    @Column(name = "emp_direccion")
    @Basic
    private String direccion;

    @Column(name = "emp_nombre", unique = true)
    @Basic
    private String nombre;

    @Column(name = "emp_email_pass")
    @Basic
    private String emailPass;

    @Column(name = "emp_logo_url")
    @Basic
    private String logoUrl;

    @ManyToOne(targetEntity = Tercero.class)
    private Tercero representante;

    @Column(name = "emp_nit")
    @Basic
    private String nit;

    @ManyToOne(targetEntity = Poblado.class)
    private Poblado poblado;

    @Column(name = "emp_logo")
    @Basic
    private Blob logo;

    @Column(name = "emp_email_host")
    @Basic
    private String emailHost;

    @Column(name = "emp_id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "emp_id")
    private Long id;

    @Column(name = "emp_radicado_interno")
    @Basic
    private String radicadoInterno;

    @Column(name = "emp_telefono")
    @Basic
    private String telefono;

    @Column(name = "emp_email_port")
    @Basic
    private String emailPort;

    @Column(name = "emp_radicado_entrada")
    @Basic
    private String radicadoEntrada;

    @Column(name = "emp_email")
    @Basic
    private String email;

    public Empresa() {

    }

    public String getRadicadoSalida() {
        return this.radicadoSalida;
    }

    public void setRadicadoSalida(String radicadoSalida) {
        this.radicadoSalida = radicadoSalida;
    }

    public String getLogoFondoCarta() {
        return this.logoFondoCarta;
    }

    public void setLogoFondoCarta(String logoFondoCarta) {
        this.logoFondoCarta = logoFondoCarta;
    }

    public String getArchivoRuta() {
        return this.archivoRuta;
    }

    public void setArchivoRuta(String archivoRuta) {
        this.archivoRuta = archivoRuta;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmailPass() {
        return this.emailPass;
    }

    public void setEmailPass(String emailPass) {
        this.emailPass = emailPass;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Tercero getRepresentante() {
        return this.representante;
    }

    public void setRepresentante(Tercero representante) {
        this.representante = representante;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Poblado getPoblado() {
        return this.poblado;
    }

    public void setPoblado(Poblado poblado) {
        this.poblado = poblado;
    }

    public Blob getLogo() {
        return this.logo;
    }

    public void setLogo(Blob logo) {
        this.logo = logo;
    }

    public String getEmailHost() {
        return this.emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRadicadoInterno() {
        return this.radicadoInterno;
    }

    public void setRadicadoInterno(String radicadoInterno) {
        this.radicadoInterno = radicadoInterno;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmailPort() {
        return this.emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getRadicadoEntrada() {
        return this.radicadoEntrada;
    }

    public void setRadicadoEntrada(String radicadoEntrada) {
        this.radicadoEntrada = radicadoEntrada;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
