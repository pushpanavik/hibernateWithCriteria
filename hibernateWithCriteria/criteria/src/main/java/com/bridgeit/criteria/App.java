package com.bridgeit.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Configuration cfg=new Configuration().configure("resources/db.config.xml");
        
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
               
        Employee emp1=new Employee(101,"Prashant","abc","abc@gmail.com",12);
        Employee emp2=new Employee(102,"Anaya","xyz","pqr@gmail.com",425);
        Employee emp3=new Employee(103,"Abhilash","bnd","wer@gmail.com",7575);
        Employee emp4=new Employee(104,"Anushka","oup","lkj@gmail.com",758);
        
        session.save(emp1);
        session.save(emp2);
        session.save(emp3);
        session.save(emp4);
        
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
