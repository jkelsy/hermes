/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;



import com.sgd.hermes.model.SubSerie;
import com.sgd.hermes.model.service.facade.SubSerieFacade;
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
@Named("subSerieService")
public class SubSerieService implements Serializable{
    
    @Inject
    private SubSerieFacade subSerieFacade;

    public SubSerieFacade getSubSerieFacade() {
        return subSerieFacade;
    }
    
    public List<SubSerie> findAllBySerie(Long serieId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("serie_id", serieId);
        return subSerieFacade.findByNamedQuery("SubSerie.findAllBySerie", parameters);
    }

}
