/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;


import com.sgd.hermes.model.Departamento;
import com.sgd.hermes.model.service.facade.DepartamentoFacade;
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
@Named("deoartamentoService")
public class DepartamentoService implements Serializable{
    @Inject
    private DepartamentoFacade departamentoFacade;

    public DepartamentoFacade getDepartamentoFacade() {
        return departamentoFacade;
    }
   
   
    
    
    public Departamento findByCodigo(String codigo) {
        System.err.println("BUSCANDO DEPARTAMENTO");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codigo", codigo);
        
        List<Departamento> departamentos = departamentoFacade.findByNamedQuery("Departamento.findByCodigo", parameters);
        System.err.println("departamentos"+departamentos);
        Departamento dpto = null;
        if (!departamentos.isEmpty() && departamentos != null){
            System.err.println("shdbshbdhjsbdjhbsbdjs");
            dpto = departamentos.get(0);
        }
        
        return dpto;
    }
}
