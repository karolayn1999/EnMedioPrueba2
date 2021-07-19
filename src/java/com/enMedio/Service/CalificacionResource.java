/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Service;

import com.enMedio.Dao.CalificacionDao;
import com.enMedio.Dao.ClientesDao;
import com.enMedio.DaoImp.CalificacionDaoImp;
import com.enMedio.DaoImp.ClientesDaoImp;
import com.enMedio.Model.Calificacion;
import com.enMedio.Pojo.CalificacionPojo;
import com.enMedio.Pojo.ClientesPojo;
import java.io.IOException;
import java.util.List;
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
@Path("calificacion")
public class CalificacionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalificacionResource
     */
    public CalificacionResource() {
    }

    /**
     * Retrieves representation of an instance of com.enMedio.Service.CalificacionResource
     * @return an instance of java.lang.String
     */
    @Path("createCalificacion")
    @POST
    public String createCalificacion(
            Calificacion calificacion
            ) throws IOException {

        CalificacionDao respuesta = new CalificacionDaoImp();
        return respuesta.createCalificacion(calificacion);
    }
    
    @Path("updateCalificacion")
    @PUT
    public String updateCalificacion(
            Calificacion calificacion
            ) throws IOException {

        CalificacionDao respuesta = new CalificacionDaoImp();
        return respuesta.updateCalificacion(calificacion);
    }
    
    @Path("findCalificacionProductos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CalificacionPojo> findCalificacionProductos() throws IOException {

        CalificacionDao respuesta = new CalificacionDaoImp();
        return respuesta.findCalificacionProductos();
    }
}
