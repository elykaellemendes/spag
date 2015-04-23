/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package br.org.apaebrasil.spag.infraestrutura.repositorio.util;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DaoManagerHiber {

    private static final SessionFactory sessionFactory;
    private static Session s;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            s = sessionFactory.openSession();
        } catch (Throwable th) {
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static void persist(Object o) {
        Transaction tr = s.beginTransaction();
        s.save(o);
        tr.commit();
        s.flush();
    }

    public static List recover(String hql) {
        s=sessionFactory.openSession();
        Transaction tr = s.beginTransaction();
        Query query = s.createQuery(hql);
        tr.commit();
        s.flush();
        return query.list();
    }

    public static void update(Object o) {
        s=sessionFactory.openSession();
        Transaction tr = s.beginTransaction();
        s.update(o);
        tr.commit();
        s.flush();
    }

    public static void delete(Object o) {
        s=sessionFactory.openSession();
        Transaction tr = s.beginTransaction();
        s.delete(o);
        tr.commit();
        s.flush();
    }

    public static void main(String args[]) {
        SchemaExport se = new SchemaExport(new AnnotationConfiguration().configure());
        se.create(true, true);
    }

}
