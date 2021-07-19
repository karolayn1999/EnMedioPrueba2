/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.Dao;

import com.enMedio.Model.Calificacion;
import com.enMedio.Model.Productos;
import com.enMedio.Pojo.CalificacionPojo;
import java.util.List;

/**
 *
 * @author Karolayn Posada
 */
public interface CalificacionDao {

    public String createCalificacion(Calificacion calificacion);

    public String updateCalificacion(Calificacion calificacion);

    public List<CalificacionPojo> findCalificacionProductos();
    
}
