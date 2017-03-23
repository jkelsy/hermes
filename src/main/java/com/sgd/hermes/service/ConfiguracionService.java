/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.service;



import com.sgd.hermes.model.Departamento;
import com.sgd.hermes.model.Municipio;
import com.sgd.hermes.model.Poblado;
import com.sgd.hermes.model.service.facade.DepartamentoFacade;
import com.sgd.hermes.model.service.facade.MunicipioFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.model.UploadedFile;
/**
 *
 * @author jdmp
 */
@Stateless
public class ConfiguracionService {
    
    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Inject
    private DepartamentoFacade df;
    @Inject
    private MunicipioFacade mf;
    @Inject
    private PobladoService pobladoService;

    
    

    
    

     public void cargarDivipola(UploadedFile divipola) { 
        
        
        System.out.println("Inicianco el cargue...");
        
        if (df.findAll().isEmpty()) {
            System.out.println("En blanco..."+divipola);
            try (InputStream is = divipola.getInputstream()) {
                System.out.println("Lectura de archivo...");
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "ISO-8859-3"));
                String line;
                String[] record;

                br.readLine();//Descartar la fila donde están los encabezados.

                String[] recordInicial = br.readLine().split(";");
                String codDpto = recordInicial[0];
                String codMpio = recordInicial[1];

                Departamento departamento = new Departamento();
                departamento.setCodigo(codDpto);
                departamento.setNombre(recordInicial[3]);
                df.create(departamento);

                Municipio municipio = new Municipio();
                municipio.setCodigo(codMpio);
                municipio.setNombre(recordInicial[4]);
                municipio.setDepartamento(departamento);

                mf.create(municipio);

                Poblado poblado = new Poblado();
                poblado.setCodigo(recordInicial[2]);
                poblado.setNombre(recordInicial[5]);
                poblado.setMunicipio(municipio);
                pobladoService.getPobladoFacade().create(poblado);

                while ((line = br.readLine()) != null) {
                    record = line.split(";");
                    if(!codDpto.equals(record[0])){
                        codDpto = record[0];
                        departamento = new Departamento();
                        departamento.setCodigo(codDpto);
                        departamento.setNombre(record[3]);
                        df.create(departamento);
                    }
                    
                    if(!codMpio.equals(record[1])){
                        codMpio = record[1];
                        municipio = new Municipio();
                        municipio.setCodigo(codMpio);
                        municipio.setNombre(record[4]);
                        municipio.setDepartamento(departamento);
                        mf.create(municipio);
                    }
                    
                    poblado = new Poblado();
                    poblado.setCodigo(record[2]);
                    poblado.setNombre(record[5]);
                    poblado.setMunicipio(municipio);
                    pobladoService.getPobladoFacade().create(poblado);
                }

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }

    }
     
     
     
     
     
     
     
}
