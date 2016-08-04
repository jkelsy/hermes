/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.business;

import com.sgd.hermes.model.Cargo;
import com.sgd.hermes.model.Dependencia;
import com.sgd.hermes.model.Empresa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public List<Cargo> buscarCargos(Long empId) throws Exception{
        List<Cargo> empresaList = null;
        
        try {
            String jpql = " FROM Cargo m WHERE m.empresa.id = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, empId);
            empresaList = query.getResultList();
        } catch (Exception e) {
             System.err.println("ERRROROROORO"+e.getMessage());
            throw e;
        }
        return empresaList;
    }
   

    public List<Dependencia> buscarDependencias(Long empId) throws Exception{
        List<Dependencia> dependenciaList = null;
        
        try {
            String jpql = " FROM Dependencia d WHERE d.empresa.id = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, empId);
            dependenciaList = query.getResultList();
        } catch (Exception e) {
             System.err.println("ERRROROROORO"+e.getMessage());
            throw e;
        }
        return dependenciaList;
    }


}
