/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enMedio.DaoImp;

import com.enMedio.Dao.ClientesDao;
import com.enMedio.Model.Clientes;
import com.enMedio.Pojo.ClientesPojo;
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
public class ClientesDaoImp implements ClientesDao{

    @Override
    public String createClientes(Clientes clientes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(clientes);
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
    public String updateClientes(Clientes clientes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(clientes);
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
    public ClientesPojo findMaxComprador() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<ClientesPojo> listarClientesPojo = null;

        try {
            Query query = session.createSQLQuery("select c.nombre, c.NIT, sum(v.monto) monto from ventas v join clientes"
                    + " c on v.clientes_id=c.id group by c.id order by sum(v.monto) asc LIMIT 5").setResultTransformer(Transformers.aliasToBean(ProductoventasPojo.class));

            listarClientesPojo = query.list();

            transaction.commit();
            session.close();
        } catch (Exception e) {

            transaction.rollback();
            session.close();

        }

        return listarClientesPojo.get(0);
    }
}
