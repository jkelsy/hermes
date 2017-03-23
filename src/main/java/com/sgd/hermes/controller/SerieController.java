/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;



import com.sgd.hermes.model.Serie;
import com.sgd.hermes.model.service.facade.SerieFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "serieController")
@SessionScoped
public class SerieController implements Serializable {
    
    @Inject
    private SerieFacade serieFacade;
    private Serie seleccionado = new Serie();
     
    public SerieController() {
    }


    public List<Serie> getSeries(){
        return serieFacade.findAll();
    }

    public Serie getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Serie seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String editar(Serie s){
        this.seleccionado = s;
        return "editar";
    }
    
    public String crear(){
        this.seleccionado = new Serie();
        return "crear";
    }
    
    
    
    
    public String actualizar(){
         try {
            serieFacade.edit(seleccionado);
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
            serieFacade.create(seleccionado);
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
        return "/serie/listado";
    }
    
    
}
