/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.controller;


import com.sgd.hermes.service.ConfiguracionService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "configuracionController")
@SessionScoped
public class ConfiguracionController implements Serializable {
    
    @Inject
    ConfiguracionService configuracion;

    public ConfiguracionController() {
    }


    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();        
        
        if(file.getContents().length != 0){
                configuracion.cargarDivipola(file);
            }
        }
    
    
    
}
