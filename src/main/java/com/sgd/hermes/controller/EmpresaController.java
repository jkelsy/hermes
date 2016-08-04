/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;

import com.sgd.hermes.business.CargoFacade;
import com.sgd.hermes.business.DepartamentoFacade;
import com.sgd.hermes.business.DependenciaFacade;
import com.sgd.hermes.business.EmpresaFacade;
import com.sgd.hermes.business.MunicipioFacade;
import com.sgd.hermes.business.PobladoFacade;
import com.sgd.hermes.business.TerceroFacade;
import com.sgd.hermes.model.Cargo;
import com.sgd.hermes.model.Departamento;
import com.sgd.hermes.model.Dependencia;
import com.sgd.hermes.model.Empresa;
import com.sgd.hermes.model.Municipio;
import com.sgd.hermes.model.Poblado;
import com.sgd.hermes.model.Tercero;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;


@Named(value = "empresaController")
@SessionScoped
public class EmpresaController implements Serializable {
    
    @Inject
    private EmpresaFacade empresaFacade;

    @Inject
    private TerceroFacade terceroFacade;

    @Inject
    private DepartamentoFacade departamentoFacade;

    @Inject
    private MunicipioFacade municipioFacade;

    @Inject
    private PobladoFacade pobladoFacade;
    
    @Inject
    private CargoFacade cargoFacade;
    
    @Inject
    private DependenciaFacade dependenciaFacade;

    private Empresa seleccionado = new Empresa();
     
    private Long representanteId;
    
    private Long departamentoId;

    private Long municipioId;
    
    private Long pobladoId;

    private Long jefeId;

    private List<Departamento> departamentoList;
    
    private List<Tercero> representanteList;
    
    private List<Municipio> municipioList;
    
    private List<Poblado> pobladoList;
    
    private List<Cargo> cargoList;
    
    private List<Dependencia> dependenciaList;
    
    private List<Tercero> jefeList;
    
    private Cargo cargoInstance;
    
    private Dependencia dependenciaInstance;
    
    private String accion;

    public EmpresaController() {
    }

  public List<Empresa> getEmpresas(){
        return empresaFacade.findAll();
    }

    public Empresa getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Empresa seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Long getRepresentanteId() {
        return representanteId;
    }

    public void setRepresentanteId(Long representanteId) {
        this.representanteId = representanteId;
    }

    public List<Tercero> getRepresentanteList() {
        return representanteList;
    }

    public void setRepresentanteList(List<Tercero> representanteList) {
        this.representanteList = representanteList;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public Long getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Long municipioId) {
        this.municipioId = municipioId;
    }

    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    public List<Poblado> getPobladoList() {
        return pobladoList;
    }

    public void setPobladoList(List<Poblado> pobladoList) {
        this.pobladoList = pobladoList;
    }

    public Long getPobladoId() {
        return pobladoId;
    }

    public void setPobladoId(Long pobladoId) {
        this.pobladoId = pobladoId;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public Cargo getCargoInstance() {
        return cargoInstance;
    }

    public void setCargoInstance(Cargo cargoInstance) {
        this.cargoInstance = cargoInstance;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Dependencia getDependenciaInstance() {
        return dependenciaInstance;
    }

    public void setDependenciaInstance(Dependencia dependenciaInstance) {
        this.dependenciaInstance = dependenciaInstance;
    }

    public List<Dependencia> getDependenciaList() {
        return dependenciaList;
    }

    public void setDependenciaList(List<Dependencia> dependenciaList) {
        this.dependenciaList = dependenciaList;
    }

    public Long getJefeId() {
        return jefeId;
    }

    public void setJefeId(Long jefeId) {
        this.jefeId = jefeId;
    }

    public List<Tercero> getJefeList() {
        return jefeList;
    }

    public void setJefeList(List<Tercero> jefeList) {
        this.jefeList = jefeList;
    }

    
    
    
    public String editar(Empresa c){
        departamentoList = departamentoFacade.findAll();
        representanteList = terceroFacade.findAll();
        
        this.seleccionado = c;
        
        if (this.seleccionado.getRepresentante()!=null) {
            this.representanteId = this.seleccionado.getRepresentante().getId();
            this.departamentoId = this.seleccionado.getPoblado().getMunicipio().getDepartamento().getId();
            try {
                buscarMunicipio();
            } catch (Exception e) {
            }
            
            this.municipioId = this.seleccionado.getPoblado().getMunicipio().getId();
            try {
                buscarPoblado();
            } catch (Exception e) {
            }
            
        }
        
        
        return "editar";
    }
    
    public String crear(){
        representanteList = terceroFacade.findAll();
        departamentoList = departamentoFacade.findAll();

        this.seleccionado = new Empresa();
        return "crear";
    }
    
    
    
    
    public String actualizar(){
         try {
             seleccionado.setPoblado(pobladoFacade.find(pobladoId));
             seleccionado.setRepresentante(terceroFacade.find(representanteId));
            empresaFacade.edit(seleccionado);
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
             seleccionado.setPoblado(pobladoFacade.find(pobladoId));
             seleccionado.setRepresentante(terceroFacade.find(representanteId));
            empresaFacade.create(seleccionado);
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
        return "/secured/empresa/listado";
    }
    
    
    public void buscarMunicipio() throws Exception {
        try {
            municipioId = null;
            pobladoId = null;
            municipioList = municipioFacade.buscarMunicipio(departamentoId);
            
            if (municipioList != null){
                municipioId = municipioList.get(0).getId();
                pobladoList = null;
                buscarPoblado();

            }
            
            if (pobladoList != null){
                pobladoId = pobladoList.get(0).getId();
            }
            
        } catch (Exception e) {
            throw e;
        }

    }

    public void buscarPoblado() throws Exception {
        try {
            pobladoList = pobladoFacade.buscarPoblado(municipioId);
            if (pobladoList != null){
                pobladoId = pobladoList.get(0).getId();
            }
            
        } catch (Exception e) {
            throw e;
        }

    }

    public String mostrar(Empresa emp) throws Exception{
        this.seleccionado = emp;
        
        try {
            cargoList = empresaFacade.buscarCargos(this.seleccionado.getId());
            dependenciaList = empresaFacade.buscarDependencias(this.seleccionado.getId());
        } catch (Exception e) {
            throw e;
        }
        
        
        return "mostrar";
        
    }
    
    public void registraCargo() throws Exception{
        
        try {
            cargoInstance.setEmpresa(seleccionado);
            
            if (accion.equals("Grabar")){
               cargoFacade.create(cargoInstance); 
            }else{
                if (accion.equals("Actualizar")){
                    cargoFacade.edit(cargoInstance); 
                }
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
           cargoList = empresaFacade.buscarCargos(seleccionado.getId());
        }
        
    }
    

    public void crearCargo(){
        this.accion = "Grabar";
        this.cargoInstance = new Cargo();
    }

    
    public void seleccionarCargo(Cargo car){
        this.accion = "Actualizar";
        this.cargoInstance = car;
    }
    
    
    public void eliminarCargo(){
         try {
            cargoFacade.remove(cargoInstance);
            cargoList = empresaFacade.buscarCargos(this.seleccionado.getId());
            
        } catch (Exception e) {
            
        }finally{
           
        }
    }
    
    
    
    public void crearDependencia(){
        this.accion = "Grabar";
        this.dependenciaInstance = new Dependencia();
        this.jefeList = terceroFacade.findAll();
    }
    
    public void seleccionarDependencia(Dependencia depen){
        this.accion = "Actualizar";
        this.dependenciaInstance = depen;
        if (this.dependenciaInstance.getJefe() !=null){
            this.jefeId = this.dependenciaInstance.getJefe().getId();
        }
        this.jefeList = terceroFacade.findAll();
    } 
    
    
    public void registraDependencia() throws Exception{
        
        try {
            dependenciaInstance.setEmpresa(seleccionado);
            dependenciaInstance.setJefe(terceroFacade.find(jefeId));
            
            if (accion.equals("Grabar")){
               dependenciaFacade.create(dependenciaInstance); 
            }else{
                if (accion.equals("Actualizar")){
                    dependenciaFacade.edit(dependenciaInstance); 
                }
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
           dependenciaList = empresaFacade.buscarDependencias(seleccionado.getId());
        }
        
    } 
    
     public void eliminarDependencia(){
         
         
         try {
            dependenciaFacade.remove(dependenciaInstance);
            this.jefeId = null;
            dependenciaList = empresaFacade.buscarDependencias(seleccionado.getId());
            
        } catch (Exception e) {
             System.err.println("Error"+e);
        }finally{
           
        }
    }
    
}
