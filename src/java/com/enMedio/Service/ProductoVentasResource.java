/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Service;

import com.enMedio.Dao.ProductoVentasDao;
import com.enMedio.DaoImp.ProductoVentasDaoImp;
import com.enMedio.Model.Productoventas;
import com.enMedio.Pojo.ProductoventasPojo;
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
@Path("productoVentas")
public class ProductoVentasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductoVentasResource
     */
    public ProductoVentasResource() {
    }

    /**
     * Retrieves representation of an instance of com.enMedio.Service.ProductoVentasResource
     * @return an instance of java.lang.String
     */
    @Path("createProductoventas")
    @POST
    public String createProductoventas(
            Productoventas productoventas
            ) throws IOException {

        ProductoVentasDao respuesta = new ProductoVentasDaoImp();
        return respuesta.createProductoventas(productoventas);
    }
    
    @Path("updateProductoventas")
    @PUT
    public String updateProductoventas(
            Productoventas productoventas
            ) throws IOException {

        ProductoVentasDao respuesta = new ProductoVentasDaoImp();
        return respuesta.updateProductoventas(productoventas);
    }
    
    @Path("findProductosStock")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoventasPojo> findProductosStock() throws IOException {

        ProductoVentasDao respuesta = new ProductoVentasDaoImp();
        return respuesta.findProductosStock();
    }
    
    @Path("findProductosVentas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoventasPojo> findProductosVentas() throws IOException {

        ProductoVentasDao respuesta = new ProductoVentasDaoImp();
        return respuesta.findProductosVentas();
    }
}
