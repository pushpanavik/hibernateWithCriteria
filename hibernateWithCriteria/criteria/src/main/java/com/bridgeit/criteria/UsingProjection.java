package com.bridgeit.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import bean.Employee;

public class UsingProjection {

	public static void main(String[] args) {
		 Configuration cfg=new Configuration().configure("resources/db.config.xml");
		   
	     SessionFactory sessionFactory=cfg.buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     @SuppressWarnings("deprecation")
	     Criteria c=session.createCriteria(Employee.class);
	     Projection p=Projections.property("name");
	     c.setProjection(p);
	     List<String> name=c.list();
	     for(String names : name)
	     {
	    	 System.out.println(names);
	     }
	     

	}

}
