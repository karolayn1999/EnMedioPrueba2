/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.DaoImp;

import com.enMedio.Dao.ProductosDao;
import com.enMedio.Model.Productos;
import com.enMedio.Service.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Karolayn Posada
 */
public class ProductosDaoImp implements ProductosDao{

    @Override
    public String updateProductos(Productos productos) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(productos);
            transaction.commit();
            session.close();
            return "success";

        } catch (Exception e) {
            transaction.rollback();
            session.close();
            System.err.println(e);
            return "error";
        }
    }

    @Override
    public String createProductos(Productos productos) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(productos);
            transaction.commit();
            session.close();
            return "success";

        } catch (Exception e) {
            transaction.rollback();
            session.close();
            System.err.println(e);
            return "error";
        }
    }

    @Override
    public String updateProductosEstado(Integer id, Boolean estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("update productos set estado=" + estado + " where id=" + id);
            query.executeUpdate();

            transaction.commit();
            session.close();

            if (estado == true) {
                return "El producto se ha activado con exito";
            } else {
                return "El producto se ha inactivado con exito";
            }

        } catch (Exception e) {

            transaction.rollback();
            session.close();
            if (estado == true) {
                return "El producto no se ha podido activar";
            } else {
                return "El producto no se ha podido inactivar";
            }
        }
    }
    
}
