package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.TipoArmario;

@Stateless
@Named("tipoArmario")
public class TipoArmarioFacade extends AbstractFacade<TipoArmario, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoArmarioFacade() {
        super(TipoArmario.class);
    }

}
