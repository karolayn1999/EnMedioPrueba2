/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Service;

import com.enMedio.Dao.VentasDao;
import com.enMedio.DaoImp.VentasDaoImp;
import com.enMedio.Model.Ventas;
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
@Path("ventas")
public class VentasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VentasResource
     */
    public VentasResource() {
    }

    @Path("createVentas")
    @POST
    public String createVentas(
            Ventas ventas
            ) throws IOException {

        VentasDao respuesta = new VentasDaoImp();
        return respuesta.createVentas(ventas);
    }
    
    @Path("updateVentas")
    @PUT
    public String updateVentas(
            Ventas ventas
            ) throws IOException {

        VentasDao respuesta = new VentasDaoImp();
        return respuesta.updateVentas(ventas);
    }
}
