/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;

import com.sgd.hermes.model.TRDTipoDocumental;
import com.sgd.hermes.model.service.facade.TRDTipoDocumentalFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("trdTipoDocumentalService")
public class TrdTipoDocumentalService implements Serializable {

    @Inject
    TRDTipoDocumentalFacade tRDTipoDocumentalFacade;

    public TRDTipoDocumentalFacade gettRDTipoDocumentalFacade() {
        return tRDTipoDocumentalFacade;
    }

    public List<TRDTipoDocumental> findAllByTrd(Long trd) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("trd_id", trd);
        return tRDTipoDocumentalFacade.findByNamedQuery("TRDTipoDocumental.findAllByTrd", parameters);
    }

    public List<TRDTipoDocumental> findAllByTrdAndTipoDocumental(Long trd, Long tipoDocumental) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("trd_id", trd);
        parameters.put("tipo_documental_id", tipoDocumental);
        return tRDTipoDocumentalFacade.findByNamedQuery("TRDTipoDocumental.findAllByTrdAndTipoDocumental", parameters);
    }

}
