/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.convert;

import com.sgd.hermes.model.TablaRetencionDocumental;
import com.sgd.hermes.model.service.facade.TablaRetencionDocumentalFacade;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;





/**
 *
 * @author jdmp
 */

@FacesConverter("trdConverter")
public class TrdConvert implements Converter{
    
    
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        
        if(value != null && value.trim().length() > 0) {
            try {
                TablaRetencionDocumentalFacade trdFacade = fc.getCurrentInstance().getApplication().evaluateExpressionGet(fc, "#{tablaRetencionDocumental}", TablaRetencionDocumentalFacade.class);
                
                TablaRetencionDocumental trd = trdFacade.find(Long.parseLong(value));
                return trd;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid rol."));
            }
        }
        else {
            return null;
        }
    }
    
    
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((TablaRetencionDocumental) object).getId());
        }
        else {
            return null;
        }
    }   
}
