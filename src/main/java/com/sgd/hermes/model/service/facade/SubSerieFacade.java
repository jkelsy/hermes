package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.SubSerie;

@Stateless
@Named("subSerie")
public class SubSerieFacade extends AbstractFacade<SubSerie, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubSerieFacade() {
        super(SubSerie.class);
    }

}
