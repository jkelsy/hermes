/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;

import com.sgd.hermes.business.DependenciaFacade;
import com.sgd.hermes.model.Dependencia;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "dependenciaController")
@SessionScoped
public class DependenciaController implements Serializable {
    
    @Inject
    private DependenciaFacade dependenciaFacade;
    private Dependencia seleccionado = new Dependencia();
     
    public DependenciaController() {
    }


    public List<Dependencia> getDependencias(){
        return dependenciaFacade.findAll();
    }

    public Dependencia getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Dependencia seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String editar(Dependencia d){
        this.seleccionado = d;
        return "editar";
    }
    
    public String crear(){
        this.seleccionado = new Dependencia();
        return "crear";
    }
    
    
    
    
    public String actualizar(){
         try {
            dependenciaFacade.edit(seleccionado);
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
            dependenciaFacade.create(seleccionado);
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
        return "/dependencia/listado";
    }
    
    
}
