package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.TablaRetencionDocumental;

@Stateless
@Named("tablaRetencionDocumental")
public class TablaRetencionDocumentalFacade extends AbstractFacade<TablaRetencionDocumental, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TablaRetencionDocumentalFacade() {
        super(TablaRetencionDocumental.class);
    }

}
