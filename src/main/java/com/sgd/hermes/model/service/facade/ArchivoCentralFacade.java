package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.ArchivoCentral;

@Stateless
@Named("archivoCentral")
public class ArchivoCentralFacade extends AbstractFacade<ArchivoCentral, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArchivoCentralFacade() {
        super(ArchivoCentral.class);
    }

}
