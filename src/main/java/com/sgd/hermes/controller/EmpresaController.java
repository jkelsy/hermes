/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;

import com.sgd.hermes.model.Cargo;
import com.sgd.hermes.model.CentroCosto;
import com.sgd.hermes.model.Departamento;
import com.sgd.hermes.model.Empresa;
import com.sgd.hermes.model.Municipio;
import com.sgd.hermes.model.Poblado;
import com.sgd.hermes.model.Tercero;
import com.sgd.hermes.model.service.facade.CargoFacade;
import com.sgd.hermes.model.service.facade.CentroCostoFacade;
import com.sgd.hermes.service.DepartamentoService;
import com.sgd.hermes.service.EmpresaService;
import com.sgd.hermes.service.MunicipioService;
import com.sgd.hermes.service.PobladoService;
import com.sgd.hermes.service.TerceroService;
import java.io.BufferedReader;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;

@Named(value = "empresaController")
@ViewScoped
public class EmpresaController implements Serializable {

    @Inject
    private EmpresaService empresaService;

    @Inject
    private TerceroService terceroService;

    @Inject
    private DepartamentoService departamentoService;

    @Inject
    private MunicipioService municipioService;

    @Inject
    private PobladoService pobladoService;


//    @Inject
//    private PobladoFacade pobladoFacade;
    @Inject
    private CargoFacade cargoFacade;

    @Inject
    private CentroCostoFacade centroCostoFacade;

    private Empresa empresaSeleccionada;

    private Long representanteId;

    private Long departamentoId;

    private Long municipioId;

    private Long pobladoId;

    private Long jefeId;

    private List<Empresa> empresaList;
    private List<Departamento> departamentoList;
    private List<Tercero> representanteList;
    private List<Municipio> municipioList;
    private List<Poblado> pobladoList;
    private List<Cargo> cargoList;
    private List<CentroCosto> centroCostoList;
    private List<Tercero> jefeList;

    private Cargo cargoInstance;

    private CentroCosto centroCostoInstance;

    private String labelAccionTrd;

    private BufferedReader reader;

    public Empresa getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }

    public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
        this.empresaSeleccionada = empresaSeleccionada;
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

    public CentroCosto getCentroCostoInstance() {
        return centroCostoInstance;
    }

    public void setCentroCostoInstance(CentroCosto centroCostoInstance) {
        this.centroCostoInstance = centroCostoInstance;
    }

    public List<CentroCosto> getCentroCostoList() {
        return centroCostoList;
    }

    public void setCentroCostoList(List<CentroCosto> centroCostoList) {
        this.centroCostoList = centroCostoList;
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

    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    public String getLabelAccionTrd() {
        return labelAccionTrd;
    }

    public void setLabelAccionTrd(String labelAccionTrd) {
        this.labelAccionTrd = labelAccionTrd;
    }

    public void onListado() {
        // OJO SOLO SE DEBEN LISTAR LAS EMPRESAS ASOCIADAS A EL USUARIO LOGUEADO
        this.empresaList = empresaService.getEmpresaFacade().findAll();
    }

    public void crearEmpresa() {

        labelAccionTrd = "Grabar";

        // SE VERIFICA SI HAY UNA INSTANCIA, SINO SE CREA NEW
        if (empresaSeleccionada == null) {
            empresaSeleccionada = new Empresa();
        } else {

            if (empresaSeleccionada.getRepresentante() != null) {
                representanteId = empresaSeleccionada.getRepresentante().getId();
            }

            if (empresaSeleccionada.getPoblado() != null) {
                pobladoId = empresaSeleccionada.getPoblado().getId();
            }

            labelAccionTrd = "Actualizar";
        }

        // SE LLENAN LAS LISTAS QUE SEAN NECESARIAS
        departamentoList = departamentoService.getDepartamentoFacade().findAll();
        representanteList = terceroService.getTerceroFacade().findAll();

        if (!departamentoList.isEmpty() && departamentoList != null) {
            if (empresaSeleccionada.getPoblado() == null) {
                // BUSCAMOS A CORDOBA
                Departamento dTemp = departamentoService.findByCodigo("23");
                if (dTemp != null) {
                    departamentoId = dTemp.getId();
                } else {
                    departamentoId = departamentoList.get(0).getId();
                }

                try {
                    buscarMunicipio();
                } catch (Exception e) {
                    System.err.println("EXISTE UN ERROR BUSCANDO EL MUNICIPIO"+e);
                }finally{
                }

            } else {
                departamentoId = empresaSeleccionada.getPoblado().getMunicipio().getDepartamento().getId();
                try {
                    buscarMunicipio();
                    municipioId = empresaSeleccionada.getPoblado().getMunicipio().getId();

                    //buscarPoblado();
                    pobladoId = empresaSeleccionada.getPoblado().getId();

                } catch (Exception e) {
                    System.err.println("EXISTE UN ERROR BUSCANDO EL MUNICIPIO O POBLADO"+e);
                }
            }
        }
        
        // SE COLOCA EN NULL LAS INSTANCIAS QUE DEBEN LLEVAR ESTE VALOR
    }

    /*

    public String editar(Empresa c) {
        departamentoList = departamentoFacade.findAll();
        representanteList = terceroFacade.findAll();

        this.seleccionado = c;

        if (this.seleccionado.getRepresentante() != null) {
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

    
    
    
    public String crear() {
        representanteList = terceroFacade.findAll();
        departamentoList = departamentoFacade.findAll();

        this.seleccionado = new Empresa();
        return "crear";
    }

    public String actualizar() {
        try {
            seleccionado.setPoblado(pobladoService.getPobladoFacade().find(pobladoId));
            seleccionado.setRepresentante(terceroFacade.find(representanteId));
            empresaService.getEmpresaFacade().edit(seleccionado);
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
     */
    public String grabar() {
        String mensaje = "";
        try {

            empresaSeleccionada.setPoblado(pobladoService.getPobladoFacade().find(pobladoId));
            empresaSeleccionada.setRepresentante(terceroService.getTerceroFacade().find(representanteId));

            if (pobladoId != null) {
                Poblado pobTemp = pobladoService.getPobladoFacade().find(pobladoId);
                if (!pobTemp.equals(empresaSeleccionada.getPoblado())) {
                    empresaSeleccionada.setPoblado(pobTemp);
                }
            }

            if (representanteId != null) {
                Tercero terTemp = terceroService.getTerceroFacade().find(representanteId);
                if (!terTemp.equals(empresaSeleccionada.getRepresentante())) {
                    empresaSeleccionada.setRepresentante(terTemp);
                }
            }

            if (empresaSeleccionada.getId() == null) {
                empresaService.getEmpresaFacade().create(empresaSeleccionada);
            } else {
                empresaService.getEmpresaFacade().edit(empresaSeleccionada);
            }

            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Creado!"));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
            System.err.println("ERRRO AL GRABAR" + e);
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

        return null;

    }

    public void buscarMunicipio() throws Exception {
        try {
            municipioId = null;
            pobladoId = null;
            municipioList = municipioService.findAllByDepartamento(departamentoId);

            if (municipioList != null) {
                municipioId = municipioList.get(0).getId();
                pobladoList = null;
                buscarPoblado();

            }

            if (pobladoList != null) {
                pobladoId = pobladoList.get(0).getId();
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void buscarPoblado() throws Exception {
        try {
            pobladoList = pobladoService.findAllByMunicipio(municipioId);
            if (pobladoList != null) {
                pobladoId = pobladoList.get(0).getId();
            }

        } catch (Exception e) {
            throw e;
        }

    }

    /*
    public String mostrar(Empresa emp) throws Exception {
        this.seleccionado = emp;

        try {
            //cargoList = empresaFacade.buscarCargos(this.seleccionado.getId());
            //centroCostoList = empresaFacade.buscarCentroCostos(this.seleccionado.getId());
        } catch (Exception e) {
            throw e;
        }

        return "mostrar";

    }

    public void registraCargo() throws Exception {

        try {
            cargoInstance.setEmpresa(seleccionado);

            if (accion.equals("Grabar")) {
                cargoFacade.create(cargoInstance);
            } else if (accion.equals("Actualizar")) {
                cargoFacade.edit(cargoInstance);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            //cargoList = empresaFacade.buscarCargos(seleccionado.getId());
        }

    }

    public void crearCargo() {
        this.accion = "Grabar";
        this.cargoInstance = new Cargo();
    }

    public void seleccionarCargo(Cargo car) {
        this.accion = "Actualizar";
        this.cargoInstance = car;
    }

    public void eliminarCargo() {
        try {
            cargoFacade.remove(cargoInstance);
            //cargoList = empresaFacade.buscarCargos(this.seleccionado.getId());

        } catch (Exception e) {

        } finally {

        }
    }
    public void crearCentroCosto() {
        this.accion = "Grabar";
        this.centroCostoInstance = new CentroCosto();
        this.jefeList = terceroService.getTerceroFacade().findAll();
    }

    public void seleccionarCentroCosto(CentroCosto centroCosto) {
        this.accion = "Actualizar";
        this.centroCostoInstance = centroCosto;
        if (this.centroCostoInstance.getJefe() != null) {
            this.jefeId = this.centroCostoInstance.getJefe().getId();
        }
        this.jefeList = terceroService.getTerceroFacade().findAll();
    }

    public void registraCentroCosto() throws Exception {

        try {
            centroCostoInstance.setEmpresa(empresaSeleccionada);
            centroCostoInstance.setJefe(terceroService.getTerceroFacade().find(jefeId));

            if (accion.equals("Grabar")) {
                centroCostoFacade.create(centroCostoInstance);
            } else if (accion.equals("Actualizar")) {
                centroCostoFacade.edit(centroCostoInstance);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //centroCostoList = empresaFacade.buscarCentroCostos(seleccionado.getId());
        }

    }

    public void eliminarCentroCosto() {

        try {
            centroCostoFacade.remove(centroCostoInstance);
            this.jefeId = null;
            //centroCostoList = empresaFacade.buscarCentroCostos(seleccionado.getId());

        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {

        }
    }
     */
}
