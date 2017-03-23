package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.TRDTipoDocumental;

@Stateless
@Named("TRDTipoDocumental")
public class TRDTipoDocumentalFacade extends AbstractFacade<TRDTipoDocumental, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TRDTipoDocumentalFacade() {
        super(TRDTipoDocumental.class);
    }

}
