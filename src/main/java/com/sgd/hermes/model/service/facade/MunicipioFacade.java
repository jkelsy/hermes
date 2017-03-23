package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.Municipio;

@Stateless
@Named("municipio")
public class MunicipioFacade extends AbstractFacade<Municipio, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }

}
