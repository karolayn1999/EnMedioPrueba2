/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Service;

import com.enMedio.Dao.ClientesDao;
import com.enMedio.DaoImp.ClientesDaoImp;
import com.enMedio.Model.Clientes;
import com.enMedio.Pojo.ClientesPojo;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Karolayn Posada
 */
@Path("cliente")
public class ClienteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    /**
     * Retrieves representation of an instance of com.enMedio.Service.ClienteResource
     * @return an instance of java.lang.String
     */
    
    @Path("createClientes")
    @POST
    public String createClientes(
            Clientes clientes
            ) throws IOException {

        ClientesDao respuesta = new ClientesDaoImp();
        return respuesta.createClientes(clientes);
    }
    
    @Path("updateClientes")
    @PUT
    public String updateClientes(
            Clientes clientes
            ) throws IOException {

        ClientesDao respuesta = new ClientesDaoImp();
        return respuesta.updateClientes(clientes);
    }
    
    @Path("findMaxComprador")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClientesPojo findMaxComprador() throws IOException {

        ClientesDao respuesta = new ClientesDaoImp();
        return respuesta.findMaxComprador();
    }
}
