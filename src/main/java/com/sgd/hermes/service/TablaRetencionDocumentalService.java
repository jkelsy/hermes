/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;



import com.sgd.hermes.model.TablaRetencionDocumental;
import com.sgd.hermes.model.service.facade.TablaRetencionDocumentalFacade;
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
@Named("trdService")
public class TablaRetencionDocumentalService implements Serializable{
    
    @Inject
    private TablaRetencionDocumentalFacade trdFacade;

    public TablaRetencionDocumentalFacade getTrdFacade() {
        return trdFacade;
    }

    public void setTrdFacade(TablaRetencionDocumentalFacade trdFacade) {
        this.trdFacade = trdFacade;
    }
    
       
    
    public List<TablaRetencionDocumental> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa_id", empresa);
        return trdFacade.findByNamedQuery("TablaRetencionDocumental.findByEmpresa", parameters);
    }
}
