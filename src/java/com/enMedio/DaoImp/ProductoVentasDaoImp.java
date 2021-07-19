/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.DaoImp;

import com.enMedio.Dao.ProductoVentasDao;
import com.enMedio.Model.Productoventas;
import com.enMedio.Pojo.ProductoventasPojo;
import com.enMedio.Service.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Karolayn Posada
 */
public class ProductoVentasDaoImp implements ProductoVentasDao{

    @Override
    public String createProductoventas(Productoventas productoventas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(productoventas);
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
    public String updateProductoventas(Productoventas productoventas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(productoventas);
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
    public List<ProductoventasPojo> findProductosStock() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<ProductoventasPojo> listarProductoPojo = null;

        try {
            Query query = session.createSQLQuery("select pv.idProducto, sum(pv.cantidad) venta, sum(c.cantidad) compras, p.nombre "
                    + "sum(c.cantidad) - sum(pv.cantidad) cantidadDisponible from productoventas pv join productos p"
                    + " on p.id = pv.idProducto join compras c on c.productos_id = p.id  where p.estado=true group by p.id").setResultTransformer(Transformers.aliasToBean(ProductoventasPojo.class));

            listarProductoPojo = query.list();

            transaction.commit();
            session.close();
        } catch (Exception e) {

            transaction.rollback();
            session.close();

        }

        return listarProductoPojo;
    }

    @Override
    public List<ProductoventasPojo> findProductosVentas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<ProductoventasPojo> listarProductoPojo = null;

        try {
            Query query = session.createSQLQuery("select pv.idProducto, sum(pv.cantidad) venta, p.nombre "
                    + "from productoventas pv join productos p on p.id = pv.idProducto  where p.estado=true group by p.id").setResultTransformer(Transformers.aliasToBean(ProductoventasPojo.class));

            listarProductoPojo = query.list();

            transaction.commit();
            session.close();
        } catch (Exception e) {

            transaction.rollback();
            session.close();

        }

        return listarProductoPojo;
    }
}
