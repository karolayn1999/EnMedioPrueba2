/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Dao;

import com.enMedio.Model.Clientes;
import com.enMedio.Pojo.ClientesPojo;

/**
 *
 * @author Karolayn Posada
 */
public interface ClientesDao {

    public String createClientes(Clientes clientes);
    
    public String updateClientes(Clientes clientes);

    public ClientesPojo findMaxComprador();
    
}
