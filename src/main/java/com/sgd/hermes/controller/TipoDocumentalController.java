/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;

import com.sgd.hermes.model.TipoDocumental;
import com.sgd.hermes.service.TipoDocumentalService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "tipoDocumentalController")
@SessionScoped
public class TipoDocumentalController implements Serializable {

    @Inject
    private TipoDocumentalService tipoDocumentalService;

    private List<TipoDocumental> tipoDocumentalList;

    private TipoDocumental seleccionado;

    private Long seleccionadoId;
    
    private String labelAccionTrd;

    public List<TipoDocumental> getTipoDocumentalList() {
        return tipoDocumentalList;
    }

    public void setTipoDocumentalList(List<TipoDocumental> tipoDocumentalList) {
        this.tipoDocumentalList = tipoDocumentalList;
    }

    public TipoDocumental getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(TipoDocumental seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Long getSeleccionadoId() {
        return seleccionadoId;
    }

    public void setSeleccionadoId(Long seleccionadoId) {
        this.seleccionadoId = seleccionadoId;
    }

    public String getLabelAccionTrd() {
        return labelAccionTrd;
    }

    public void setLabelAccionTrd(String labelAccionTrd) {
        this.labelAccionTrd = labelAccionTrd;
    }
    
    
    
    

    public void onListado() {
        tipoDocumentalList = tipoDocumentalService.getTipoDocumentalFacade().findAll();
    }

    public void crearTipoDocumental() {
        
        if(seleccionadoId != null){
            seleccionado = tipoDocumentalService.getTipoDocumentalFacade().find(seleccionadoId);
        }else{
            seleccionado = new TipoDocumental();
        }



        labelAccionTrd = "Grabar";

        if (seleccionado.getId() != null) {
            labelAccionTrd = "Actualizar";
        }

    }

    /*   
    
    public String actualizar(){
         try {
            tipoDocumentalFacade.edit(seleccionado);
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Actualizado!"));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }finally{
             FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
         }
         
        return "editar";
    }
    
    public String grabar(){
         try {
            tipoDocumentalFacade.create(seleccionado);
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Creado!"));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }finally{
             FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
         }
         
        setSeleccionado(seleccionado);
        return "editar";
    }
  
    
    public String listado(){
        return "/tipoDocumental/listado";
    }
     */
}
