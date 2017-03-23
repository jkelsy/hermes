/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;



import com.sgd.hermes.model.TipoArmario;
import com.sgd.hermes.model.service.facade.TipoArmarioFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "tipoArmarioController")
@SessionScoped
public class TipoArmarioController implements Serializable {
    
    @Inject
    private TipoArmarioFacade tipoArmarioFacade;
    private TipoArmario seleccionado = new TipoArmario();
     
    public TipoArmarioController() {
    }


    public List<TipoArmario> getTipoArmarios(){
        return tipoArmarioFacade.findAll();
    }

    public TipoArmario getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(TipoArmario seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String editar(TipoArmario c){
        this.seleccionado = c;
        return "editar";
    }
    
    public String crear(){
        this.seleccionado = new TipoArmario();
        return "crear";
    }
    
    
    
    
    public String actualizar(){
         try {
            tipoArmarioFacade.edit(seleccionado);
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
            tipoArmarioFacade.create(seleccionado);
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
        return "/tipoArmario/listado";
    }
    
    
}
