/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;




import com.sgd.hermes.model.service.facade.SerieFacade;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("serieService")
public class SerieService implements Serializable{
    
    @Inject
    private SerieFacade serieFacade;

    public SerieFacade getSerieFacade() {
        return serieFacade;
    }

  

}
