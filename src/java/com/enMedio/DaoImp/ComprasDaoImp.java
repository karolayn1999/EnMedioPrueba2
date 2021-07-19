/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.DaoImp;

import com.enMedio.Dao.ComprasDao;
import com.enMedio.Model.Compras;
import com.enMedio.Service.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Karolayn Posada
 */
public class ComprasDaoImp implements ComprasDao{

    @Override
    public String createCompras(Compras compras) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(compras);
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
    public String updateCalificacion(Compras compras) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(compras);
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
    
}
