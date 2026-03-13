package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo
{
 public static void main(String[] args)
 {

  Configuration cfg = new Configuration();
  cfg.configure();

  SessionFactory sf = cfg.buildSessionFactory();
  Session session = sf.openSession();

  Transaction tx = session.beginTransaction();

  Restaurant r = new Restaurant(1,"Paradise","2026-03-13","Open");

  session.save(r);

  System.out.println("Record Inserted Successfully");

  tx.commit();

  session = sf.openSession();
  tx = session.beginTransaction();

  Query q = session.createQuery
  ("update Restaurant set name=:n,status=:s where id=:i");

  q.setParameter("n","Bawarchi");
  q.setParameter("s","Closed");
  q.setParameter("i",1);

  int result = q.executeUpdate();

  System.out.println("Records Updated : "+result);

  tx.commit();

  session.close();
  sf.close();
 }

}
