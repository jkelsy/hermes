/**
 * This file was generated by the JPA Modeler
 */
package com.sgd.hermes.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author jdmp
 */
@Entity
@Table(name = "archivo_central")
public class ArchivoCentral implements Serializable {

    @Column(name = "ac_id")
    @Id
    private Long id;

    @Column(name = "ac_descripcion")
    @Basic
    private String descripcion;

    @Column(name = "ac_estante")
    @Basic
    private String estante;

    @Column(name = "ac_fecha_creacion")
    @Basic
    private Date fechaCreacion;

    @Column(name = "ac_fecha_movimiento")
    @Basic
    private Date fechaMovimiento;

    @Column(name = "ac_cajon")
    @Basic
    private String cajon;

    @Column(name = "ac_numero")
    @Basic
    private String numero;

    @Column(name = "ac_numero_conservacion")
    @Basic
    private String numeroConservacion;

    @Column(name = "ac_numero_documento")
    @Basic
    private String numeroDocumento;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "USR_PERSONA_ID")
    private Usuario creadoPor;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "USR_CREA_ID")
    private Usuario persona;

    @ManyToOne(targetEntity = TipoPreservacion.class)
    @JoinColumn(name = "TP_PRESERVA_ID")
    private TipoPreservacion tipoPreservacion;

    @ManyToOne(targetEntity = TipoArmario.class)
    @JoinColumn(name = "TP_ARMARIO_ID")
    private TipoArmario tipoArmario;

    @ManyToOne(targetEntity = TablaRetencionDocumental.class)
    @JoinColumn(name = "TRD_ID")
    private TablaRetencionDocumental tablaRetencionDocumental;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstante() {
        return this.estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaMovimiento() {
        return this.fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getCajon() {
        return this.cajon;
    }

    public void setCajon(String cajon) {
        this.cajon = cajon;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroConservacion() {
        return this.numeroConservacion;
    }

    public void setNumeroConservacion(String numeroConservacion) {
        this.numeroConservacion = numeroConservacion;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Usuario getCreadoPor() {
        return this.creadoPor;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Usuario getPersona() {
        return this.persona;
    }

    public void setPersona(Usuario persona) {
        this.persona = persona;
    }

    public TipoPreservacion getTipoPreservacion() {
        return this.tipoPreservacion;
    }

    public void setTipoPreservacion(TipoPreservacion tipoPreservacion) {
        this.tipoPreservacion = tipoPreservacion;
    }

    public TipoArmario getTipoArmario() {
        return this.tipoArmario;
    }

    public void setTipoArmario(TipoArmario tipoArmario) {
        this.tipoArmario = tipoArmario;
    }

    public TablaRetencionDocumental getTablaRetencionDocumental() {
        return this.tablaRetencionDocumental;
    }

    public void setTablaRetencionDocumental(TablaRetencionDocumental tablaRetencionDocumental) {
        this.tablaRetencionDocumental = tablaRetencionDocumental;
    }

}
