package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.Poblado;

@Stateless
@Named("poblado")
public class PobladoFacade extends AbstractFacade<Poblado, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PobladoFacade() {
        super(Poblado.class);
    }

}
