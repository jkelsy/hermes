package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.TipoPreservacion;

@Stateless
@Named("tipoPreservacion")
public class TipoPreservacionFacade extends AbstractFacade<TipoPreservacion, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPreservacionFacade() {
        super(TipoPreservacion.class);
    }

}
