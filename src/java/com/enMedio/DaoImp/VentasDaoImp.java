/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.DaoImp;

import com.enMedio.Dao.VentasDao;
import com.enMedio.Model.Ventas;
import com.enMedio.Service.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Karolayn Posada
 */
public class VentasDaoImp implements VentasDao{

    @Override
    public String createVentas(Ventas ventas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(ventas);
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
    public String updateVentas(Ventas ventas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(ventas);
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
