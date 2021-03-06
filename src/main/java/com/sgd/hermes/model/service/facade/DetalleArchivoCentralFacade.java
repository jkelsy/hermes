package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.DetalleArchivoCentral;

@Stateless
@Named("detalleArchivoCentral")
public class DetalleArchivoCentralFacade extends AbstractFacade<DetalleArchivoCentral, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleArchivoCentralFacade() {
        super(DetalleArchivoCentral.class);
    }

}
