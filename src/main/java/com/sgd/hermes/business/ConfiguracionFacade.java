/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.business;

import com.sgd.hermes.model.Cargo;
import com.sgd.hermes.model.Departamento;
import com.sgd.hermes.model.Municipio;
import com.sgd.hermes.model.Poblado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.Part;

/**
 *
 * @author jkelsy
 */
@Stateless
public class ConfiguracionFacade {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Inject
    private DepartamentoFacade df;

    @Inject
    private MunicipioFacade mf;

    @Inject
    private PobladoFacade pf;

    public void cargarDivipola(Part divipola) {
        if (df.count() == 0) {
            try (InputStream is = divipola.getInputStream()) {
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
                pf.create(poblado);

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
                    pf.create(poblado);
                }

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }

    }

}
