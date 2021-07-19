/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Dao;

import com.enMedio.Model.Ventas;

/**
 *
 * @author Karolayn Posada
 */
public interface VentasDao {

    public String createVentas(Ventas ventas);

    public String updateVentas(Ventas ventas);
    
}
