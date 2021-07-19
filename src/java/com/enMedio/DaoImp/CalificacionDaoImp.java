/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.DaoImp;

import com.enMedio.Dao.CalificacionDao;
import com.enMedio.Model.Calificacion;
import com.enMedio.Pojo.CalificacionPojo;
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
public class CalificacionDaoImp implements CalificacionDao{

    @Override
    public String createCalificacion(Calificacion calificacion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(calificacion);
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
    public String updateCalificacion(Calificacion calificacion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(calificacion);
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
    public List<CalificacionPojo> findCalificacionProductos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<CalificacionPojo> listarCalificacionPojo = null;

        try {
            Query query = session.createSQLQuery("select c.calificacion, c.observacion, p.nombre nombreProducto, "
                    + "cl.nombre nombreClientes from calificacion c join productos p on p.id=c.productos_id join clientes"
                    + " cl on cl.id=c.clientes_id").setResultTransformer(Transformers.aliasToBean(CalificacionPojo.class));

            listarCalificacionPojo = query.list();

            transaction.commit();
            session.close();
        } catch (Exception e) {

            transaction.rollback();
            session.close();

        }

        return listarCalificacionPojo;
    }
    
}
