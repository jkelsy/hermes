/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;


import com.sgd.hermes.model.Municipio;
import com.sgd.hermes.model.service.facade.MunicipioFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("municipioService")
public class MunicipioService implements Serializable{
    @Inject
    private MunicipioFacade municipioFacade;

    public MunicipioFacade getMunicipioFacade() {
        return municipioFacade;
    }

    public void setMunicipioFacade(MunicipioFacade municipioFacade) {
        this.municipioFacade = municipioFacade;
    }
    
    
    public List<Municipio> findAllByDepartamento(Long departamento) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("departamento_id", departamento);
        return municipioFacade.findByNamedQuery("Municipio.findAllByDepartamento", parameters);
    }
}
