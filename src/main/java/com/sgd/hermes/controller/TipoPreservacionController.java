/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;




import com.sgd.hermes.model.TipoPreservacion;
import com.sgd.hermes.model.service.facade.TipoPreservacionFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "tipoPreservacionController")
@SessionScoped
public class TipoPreservacionController implements Serializable {
    
    @Inject
    private TipoPreservacionFacade tipoPreservacionFacade;
    private TipoPreservacion seleccionado = new TipoPreservacion();
     
    public TipoPreservacionController() {
    }


    public List<TipoPreservacion> getTipoPreservacions(){
        return tipoPreservacionFacade.findAll();
    }

    public TipoPreservacion getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(TipoPreservacion seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String editar(TipoPreservacion tp){
        this.seleccionado = tp;
        return "editar";
    }
    
    public String crear(){
        this.seleccionado = new TipoPreservacion();
        return "crear";
    }
    
    
    
    
    public String actualizar(){
         try {
            tipoPreservacionFacade.edit(seleccionado);
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
            tipoPreservacionFacade.create(seleccionado);
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
        return "/tipoPreservacion/listado";
    }
    
    
}
