/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Service;

import com.enMedio.Dao.CalificacionDao;
import com.enMedio.Dao.ComprasDao;
import com.enMedio.DaoImp.CalificacionDaoImp;
import com.enMedio.DaoImp.ComprasDaoImp;
import com.enMedio.Model.Calificacion;
import com.enMedio.Model.Compras;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Karolayn Posada
 */
@Path("compras")
public class ComprasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ComprasResource
     */
    public ComprasResource() {
    }

    /**
     * Retrieves representation of an instance of com.enMedio.Service.ComprasResource
     * @return an instance of java.lang.String
     */
    @Path("createCompras")
    @POST
    public String createCompras(
            Compras compras
            ) throws IOException {

        ComprasDao respuesta = new ComprasDaoImp();
        return respuesta.createCompras(compras);
    }
    
    @Path("updateCalificacion")
    @PUT
    public String updateCalificacion(
            Compras compras
            ) throws IOException {

        ComprasDao respuesta = new ComprasDaoImp();
        return respuesta.updateCalificacion(compras);
    }
}
