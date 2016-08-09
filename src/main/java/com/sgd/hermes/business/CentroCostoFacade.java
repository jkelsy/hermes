/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.business;

import com.sgd.hermes.model.Cargo;
import com.sgd.hermes.model.CentroCosto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jkelsy
 */
@Stateless
public class CentroCostoFacade extends AbstractFacade<CentroCosto> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroCostoFacade() {
        super(CentroCosto.class);
    }
    
}
