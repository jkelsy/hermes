package com.sgd.hermes.model.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sgd.hermes.model.TipoArchivo;

@Stateless
@Named("tipoArchivo")
public class TipoArchivoFacade extends AbstractFacade<TipoArchivo, Long> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoArchivoFacade() {
        super(TipoArchivo.class);
    }

}
