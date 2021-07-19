/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Dao;

import com.enMedio.Model.Productoventas;
import com.enMedio.Pojo.ProductoventasPojo;
import java.util.List;

/**
 *
 * @author Karolayn Posada
 */
public interface ProductoVentasDao {

    public String createCalificacion(Productoventas productoventas);

    public String updateCalificacion(Productoventas productoventas);

    public List<ProductoventasPojo> findProductosStock();

    public List<ProductoventasPojo> findProductosVentas();
    
}
