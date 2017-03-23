/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;

import com.sgd.hermes.model.CentroCosto;
import com.sgd.hermes.model.Empresa;
import com.sgd.hermes.model.Serie;
import com.sgd.hermes.model.SubSerie;
import com.sgd.hermes.model.TRDTipoDocumental;
import com.sgd.hermes.model.TablaRetencionDocumental;
import com.sgd.hermes.model.TipoDocumental;
import com.sgd.hermes.service.CentroCostoService;
import com.sgd.hermes.service.EmpresaService;
import com.sgd.hermes.service.SerieService;
import com.sgd.hermes.service.SubSerieService;
import com.sgd.hermes.service.TablaRetencionDocumentalService;
import com.sgd.hermes.service.TipoDocumentalService;
import com.sgd.hermes.service.TrdTipoDocumentalService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "trdController")
@ViewScoped
public class TRDController implements Serializable {

    @Inject
    private TablaRetencionDocumentalService trdService;
    @Inject
    private EmpresaService empresaService;
    @Inject
    private CentroCostoService centroCostoService;
    @Inject
    private SerieService serieService;
    @Inject
    private SubSerieService subSerieService;
    @Inject
    private TipoDocumentalService tipoDocumentalService;
    @Inject
    private TrdTipoDocumentalService trdTipoDocumentalService;

    private List<Empresa> empresaList;
    private List<CentroCosto> centroCostoList;
    private List<TablaRetencionDocumental> trdList;
    private List<Serie> serieList;
    private List<SubSerie> subSerieList;
    private List<TipoDocumental> tipoDocumentalList;
    private List<TRDTipoDocumental> trdTipoDocumentalList;

    private Long empresaSelId;
    private Long centroCostoSelId;
    private Long serieSelId;
    private Long subSerieSelId;
    private Long tipoDocumentalSelId;

    private TablaRetencionDocumental trdSeleccionada;
    private String labelAccionTrd;
    private TRDTipoDocumental trdTipoDocumentalInstance;

    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    public List<CentroCosto> getCentroCostoList() {
        return centroCostoList;
    }

    public void setCentroCostoList(List<CentroCosto> centroCostoList) {
        this.centroCostoList = centroCostoList;
    }

    public Long getEmpresaSelId() {
        return empresaSelId;
    }

    public void setEmpresaSelId(Long empresaSelId) {
        this.empresaSelId = empresaSelId;
    }

    public List<TablaRetencionDocumental> getTrdList() {
        return trdList;
    }

    public void setTrdList(List<TablaRetencionDocumental> trdList) {
        this.trdList = trdList;
    }

    public Long getCentroCostoSelId() {
        return centroCostoSelId;
    }

    public void setCentroCostoSelId(Long centroCostoSelId) {
        this.centroCostoSelId = centroCostoSelId;
    }

    public List<Serie> getSerieList() {
        return serieList;
    }

    public void setSerieList(List<Serie> serieList) {
        this.serieList = serieList;
    }

    public List<SubSerie> getSubSerieList() {
        return subSerieList;
    }

    public void setSubSerieList(List<SubSerie> subSerieList) {
        this.subSerieList = subSerieList;
    }

    public Long getSerieSelId() {
        return serieSelId;
    }

    public void setSerieSelId(Long serieSelId) {
        this.serieSelId = serieSelId;
    }

    public Long getSubSerieSelId() {
        return subSerieSelId;
    }

    public void setSubSerieSelId(Long subSerieSelId) {
        this.subSerieSelId = subSerieSelId;
    }

    public TablaRetencionDocumental getTrdSeleccionada() {
        return trdSeleccionada;
    }

    public void setTrdSeleccionada(TablaRetencionDocumental trdSeleccionada) {
        this.trdSeleccionada = trdSeleccionada;
    }

    public String getLabelAccionTrd() {
        return labelAccionTrd;
    }

    public void setLabelAccionTrd(String labelAccionTrd) {
        this.labelAccionTrd = labelAccionTrd;
    }

    public List<TipoDocumental> getTipoDocumentalList() {
        return tipoDocumentalList;
    }

    public void setTipoDocumentalList(List<TipoDocumental> tipoDocumentalList) {
        this.tipoDocumentalList = tipoDocumentalList;
    }

    public Long getTipoDocumentalSelId() {
        return tipoDocumentalSelId;
    }

    public void setTipoDocumentalSelId(Long tipoDocumentalSelId) {
        this.tipoDocumentalSelId = tipoDocumentalSelId;
    }

    public List<TRDTipoDocumental> getTrdTipoDocumentalList() {
        return trdTipoDocumentalList;
    }

    public void setTrdTipoDocumentalList(List<TRDTipoDocumental> trdTipoDocumentalList) {
        this.trdTipoDocumentalList = trdTipoDocumentalList;
    }

    public TRDTipoDocumental getTrdTipoDocumentalInstance() {
        return trdTipoDocumentalInstance;
    }

    public void setTrdTipoDocumentalInstance(TRDTipoDocumental trdTipoDocumentalInstance) {
        this.trdTipoDocumentalInstance = trdTipoDocumentalInstance;
    }

    public void onListado() {
        empresaList = empresaService.getEmpresaFacade().findAll();
        if (empresaList != null || !empresaList.isEmpty()) {
            empresaSelId = empresaList.get(0).getId();
            centroCostoList = centroCostoService.findAllByEmpresa(empresaSelId);
            if (centroCostoList != null || !centroCostoList.isEmpty()) {
                centroCostoSelId = centroCostoList.get(0).getId();
            }
            trdList = trdService.findAllByEmpresa(empresaSelId);
        }

    }

    public void crearTrd() {
        labelAccionTrd = "Grabar";

        
        // SE VERIFICA SI HAY UNA INSTANCIA, SINO SE CREA NEW
        if (trdSeleccionada == null) {
            trdSeleccionada = new TablaRetencionDocumental();
        } else {
            if (trdSeleccionada.getCentroCosto() != null) {
                empresaSelId = trdSeleccionada.getCentroCosto().getEmpresa().getId();

                centroCostoSelId = trdSeleccionada.getCentroCosto().getId();
                if (empresaSelId != null) {
                    centroCostoList = centroCostoService.findAllByEmpresa(empresaSelId);
                }

            }

            if (trdSeleccionada.getSubSerie() != null) {
                subSerieSelId = trdSeleccionada.getSubSerie().getId();
                serieSelId = trdSeleccionada.getSubSerie().getSerie().getId();
                if (serieSelId != null) {
                    subSerieList = subSerieService.findAllBySerie(serieSelId);
                }
            }

            labelAccionTrd = "Actualizar";
            trdTipoDocumentalList = trdTipoDocumentalService.findAllByTrd(trdSeleccionada.getId());

        }


        // SE LLENAN LAS LISTAS QUE SEAN NECESARIAS
        empresaList = empresaService.getEmpresaFacade().findAll();
        serieList = serieService.getSerieFacade().findAll();
        tipoDocumentalList = tipoDocumentalService.getTipoDocumentalFacade().findAll();
        
        // SE COLOCA EN NULL LAS INSTANCIAS QUE DEBEN LLEVAR ESTE VALOR
        tipoDocumentalSelId = null;
        trdTipoDocumentalInstance = new TRDTipoDocumental();

    }

    public void actualizarCentroCostoPorEmpresa() {

        if (empresaSelId != null) {
            centroCostoList = centroCostoService.findAllByEmpresa(empresaSelId);
            if (centroCostoList != null) {
                centroCostoSelId = centroCostoList.get(0).getId();
                if (centroCostoSelId != null) {
                    trdList = trdService.findAllByEmpresa(empresaSelId);
                }
            }
        }
    }

    public void actualizarTRDPorEmpresa() {
        if (empresaSelId != null) {
            trdList = trdService.findAllByEmpresa(empresaSelId);
        }
    }

    public void actualizarSubserie() {

        if (serieSelId != null) {
            subSerieList = subSerieService.findAllBySerie(serieSelId);
            if (subSerieList != null) {
                subSerieSelId = subSerieList.get(0).getId();
                if (subSerieSelId != null) {
                    trdList = trdService.findAllByEmpresa(empresaSelId);
                }
            }
        }
    }

    public String grabar() {
        String mensaje = "";
        try {

            if (centroCostoSelId != null) {
                CentroCosto ccTemp = centroCostoService.getCentroCostoFacade().find(centroCostoSelId);
                if (!ccTemp.equals(trdSeleccionada.getCentroCosto())) {
                    trdSeleccionada.setCentroCosto(ccTemp);
                }
            }

            if (subSerieSelId != null) {
                SubSerie ssTemp = subSerieService.getSubSerieFacade().find(subSerieSelId);
                if (!ssTemp.equals(trdSeleccionada.getSubSerie())) {
                    trdSeleccionada.setSubSerie(ssTemp);
                }
            }

            if (trdSeleccionada.getId() == null) {
                trdService.getTrdFacade().create(trdSeleccionada);
                mensaje = "Creado";
            } else {
                trdService.getTrdFacade().edit(trdSeleccionada);
                mensaje = "Actualizado";
            }

            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Creado!"));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

        return null;
    }

    public void agregarTipoDocumentalTrd() {
        if (tipoDocumentalSelId != null) {
            TipoDocumental tipoDocumentalTemp = tipoDocumentalService.getTipoDocumentalFacade().find(tipoDocumentalSelId);

            if (trdTipoDocumentalService.findAllByTrdAndTipoDocumental(trdSeleccionada.getId(), tipoDocumentalTemp.getId()) != null) {
                //TRDTipoDocumental trdTd = new TRDTipoDocumental();
                trdTipoDocumentalInstance.setTablaRetencionDocumental(trdSeleccionada);
                trdTipoDocumentalInstance.setTipoDocumental(tipoDocumentalTemp);
                trdTipoDocumentalService.gettRDTipoDocumentalFacade().create(trdTipoDocumentalInstance);

                trdTipoDocumentalList = trdTipoDocumentalService.findAllByTrd(trdSeleccionada.getId());
                tipoDocumentalSelId = null;
                trdTipoDocumentalInstance = new TRDTipoDocumental();
            }

        }
    }

}
