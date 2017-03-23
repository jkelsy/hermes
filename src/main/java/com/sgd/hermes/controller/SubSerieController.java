/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;

import com.sgd.hermes.model.Serie;
import com.sgd.hermes.model.SubSerie;
import com.sgd.hermes.model.service.facade.SerieFacade;
import com.sgd.hermes.model.service.facade.SubSerieFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "subSerieController")
@SessionScoped
public class SubSerieController implements Serializable {

    @Inject
    private SubSerieFacade subSerieFacade;

    @Inject
    SerieFacade serieFacade;

    private SubSerie seleccionado = new SubSerie();
    private List<Serie> serieList;
    private Long serieId;

    public SubSerieController() {
    }

    public List<Serie> serieList() {
        return serieList;
    }

    public void setSerieList(List<Serie> serieList) {
        this.serieList = serieList;
    }

    public Long getSerieId() {
        return serieId;
    }

    public void setSerieId(Long serieId) {
        this.serieId = serieId;
    }
    
    
    public List<SubSerie> getSubSeries() {
        return subSerieFacade.findAll();
    }

    public SubSerie getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(SubSerie seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String editar(SubSerie s) {
        serieList = serieFacade.findAll();
        this.seleccionado = s;

        if (this.seleccionado.getSerie() != null) {
            this.serieId = this.seleccionado.getSerie().getId();
        }
        return "editar";
    }

    public String crear() {
        serieList = serieFacade.findAll();

        this.seleccionado = new SubSerie();
        return "crear";
    }

    public String actualizar() {
        try {
            seleccionado.setSerie(serieFacade.find(serieId));
            subSerieFacade.edit(seleccionado);
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Actualizado!"));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

        return "editar";
    }

    public String grabar() {
        try {
            seleccionado.setSerie(serieFacade.find(serieId));
            subSerieFacade.create(seleccionado);
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Creado!"));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

        setSeleccionado(seleccionado);
        return "editar";
    }

    public String listado() {
        return "/subSerie/listado";
    }

}
