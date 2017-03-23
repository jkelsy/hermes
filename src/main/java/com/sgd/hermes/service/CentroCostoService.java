/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;




import com.sgd.hermes.model.CentroCosto;
import com.sgd.hermes.model.service.facade.CentroCostoFacade;
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
@Named("centroCostoService")
public class CentroCostoService implements Serializable{
    
    @Inject
    private CentroCostoFacade centroCostoFacade;

    public CentroCostoFacade getCentroCostoFacade() {
        return centroCostoFacade;
    }

    
       
    
    public List<CentroCosto> findAllByEmpresa(Long empresaId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa_id", empresaId);
        return centroCostoFacade.findByNamedQuery("CentroCosto.findAllByEmpresa", parameters);
    }
}
