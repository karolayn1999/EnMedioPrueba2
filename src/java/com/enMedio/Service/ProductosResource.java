/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Service;

import com.enMedio.Dao.CalificacionDao;
import com.enMedio.Dao.ProductosDao;
import com.enMedio.DaoImp.CalificacionDaoImp;
import com.enMedio.DaoImp.ProductosDaoImp;
import com.enMedio.Model.Calificacion;
import com.enMedio.Model.Productos;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Karolayn Posada
 */
@Path("productos")
public class ProductosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductosResource
     */
    public ProductosResource() {
    }

    /**
     * Retrieves representation of an instance of com.enMedio.Service.ProductosResource
     * @return an instance of java.lang.String
     */
    @Path("createProductos")
    @POST
    public String createProductos(
            Productos productos
            ) throws IOException {

        productos.setEstado(Boolean.TRUE);
        ProductosDao respuesta = new ProductosDaoImp();
        return respuesta.createProductos(productos);
    }
    
    @Path("updateProductos")
    @PUT
    public String updateProductos(
            Productos productos
            ) throws IOException {

        ProductosDao respuesta = new ProductosDaoImp();
        return respuesta.updateProductos(productos);
    }
    
    @Path("updateProductosEstado/{estado}/{id}")
    @PUT
    public String updateProductosEstado(
            @PathParam("estado") Boolean estado,
            @PathParam("id") Integer id
            ) throws IOException {

        ProductosDao respuesta = new ProductosDaoImp();
        return respuesta.updateProductosEstado(id, estado);
    }
}
