/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;


import com.sgd.hermes.model.Departamento;
import com.sgd.hermes.model.service.facade.DepartamentoFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "departamentoController")
@SessionScoped
public class DepartamentoController implements Serializable {
    
    @Inject
    private DepartamentoFacade departamentoFacade;
    private Departamento seleccionado = new Departamento();
     
    public DepartamentoController() {
    }


    public List<Departamento> getDepartamentos(){
        return departamentoFacade.findAll();
    }

    public Departamento getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Departamento seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String editar(Departamento d){
        this.seleccionado = d;
        return "editar";
    }
    
    public String crear(){
        this.seleccionado = new Departamento();
        return "crear";
    }
    
    
    
    
    public String actualizar(){
         try {
            departamentoFacade.edit(seleccionado);
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
            departamentoFacade.create(seleccionado);
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
        return "/departamento/listado";
    }
    
    
}
