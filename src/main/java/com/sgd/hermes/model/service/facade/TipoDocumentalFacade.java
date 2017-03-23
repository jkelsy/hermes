package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.TipoDocumental;

@Stateless
@Named("tipoDocumental")
public class TipoDocumentalFacade extends AbstractFacade<TipoDocumental, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentalFacade() {
        super(TipoDocumental.class);
    }

}
