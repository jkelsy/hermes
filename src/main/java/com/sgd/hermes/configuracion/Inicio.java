/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgd.hermes.configuracion;


import com.sgd.hermes.model.Cargo;
import com.sgd.hermes.model.CentroCosto;
import com.sgd.hermes.model.Empresa;
import com.sgd.hermes.model.Permiso;
import com.sgd.hermes.model.Rol;
import com.sgd.hermes.model.Serie;
import com.sgd.hermes.model.SubSerie;
import com.sgd.hermes.model.TablaRetencionDocumental;
import com.sgd.hermes.model.Tercero;
import com.sgd.hermes.model.TipoIdentificacion;
import com.sgd.hermes.model.Usuario;
import com.sgd.hermes.model.service.facade.CargoFacade;
import com.sgd.hermes.model.service.facade.CentroCostoFacade;
import com.sgd.hermes.model.service.facade.EmpresaFacade;
import com.sgd.hermes.model.service.facade.PermisoFacade;
import com.sgd.hermes.model.service.facade.RolFacade;
import com.sgd.hermes.model.service.facade.SerieFacade;
import com.sgd.hermes.model.service.facade.SubSerieFacade;
import com.sgd.hermes.model.service.facade.TablaRetencionDocumentalFacade;
import com.sgd.hermes.model.service.facade.TerceroFacade;
import com.sgd.hermes.model.service.facade.TipoIdentificacionFacade;
import com.sgd.hermes.model.service.facade.UsuarioFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author jkelsy
 */
@Startup
@Singleton
public class Inicio {

    @Inject
    private CargoFacade cargoFacade;

    @Inject
    private UsuarioFacade usuarioFacade;

    @Inject
    private RolFacade rolFacade;

    @Inject
    private PermisoFacade permisoFacade;

    @Inject
    private TipoIdentificacionFacade tipoIdentificacionFacade;
    
    
    @Inject
    private TerceroFacade terceroFacade;
    
    @Inject
    private CentroCostoFacade centroCostoFacade;
    
     @Inject
    private EmpresaFacade empresaFacade;
     
      @Inject
    private SerieFacade serieFacade;
      
       @Inject
    private SubSerieFacade subSerieFacade;
       
       @Inject
    private TablaRetencionDocumentalFacade trdFacade;

    
    @PostConstruct
    public void iniciar() {

     
    }
}
