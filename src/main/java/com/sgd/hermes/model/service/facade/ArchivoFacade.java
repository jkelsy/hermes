package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.Archivo;

@Stateless
@Named("archivo")
public class ArchivoFacade extends AbstractFacade<Archivo, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArchivoFacade() {
        super(Archivo.class);
    }

}
