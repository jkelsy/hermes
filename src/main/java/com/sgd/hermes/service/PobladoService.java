/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;


import com.sgd.hermes.model.Poblado;
import com.sgd.hermes.model.service.facade.PobladoFacade;
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
@Named("pobladoService")
public class PobladoService implements Serializable{
    
    @Inject
    private PobladoFacade pobladoFacade;

    public PobladoFacade getPobladoFacade() {
        return pobladoFacade;
    }

    public void setPobladoFacade(PobladoFacade pobladoFacade) {
        this.pobladoFacade = pobladoFacade;
    }

    
    public List<Poblado> findAllByMunicipio(Long municipio) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("municipio_id", municipio);
        return pobladoFacade.findByNamedQuery("Poblado.findAllByMunicipio", parameters);
    }
   
}
