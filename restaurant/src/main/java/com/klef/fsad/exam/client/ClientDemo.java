package com.klef.fsad.exam.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Component
public class ClientDemo {

    @Autowired
    private EntityManagerFactory factory;

    public void updateRestaurant(int id,String name,String status)
    {
        EntityManager em = factory.createEntityManager();
        Session session = em.unwrap(Session.class);

        Transaction tx = session.beginTransaction();

        String hql = "update Restaurant set name=:name, status=:status where id=:id";

        Query q = session.createQuery(hql);
        q.setParameter("name",name);
        q.setParameter("status",status);
        q.setParameter("id",id);

        q.executeUpdate();

        tx.commit();
        session.close();
    }
}