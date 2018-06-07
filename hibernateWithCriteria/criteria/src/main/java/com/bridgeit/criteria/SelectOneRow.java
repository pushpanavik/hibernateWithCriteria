package com.bridgeit.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Employee;

public class SelectOneRow {

	public static void main(String[] args) {
 Configuration cfg=new Configuration().configure("resources/db.config.xml");
	     
	     SessionFactory sessionFactory=cfg.buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     @SuppressWarnings("deprecation")
		Criteria c=session.createCriteria(Employee.class);
	    Criterion cr =Restrictions.eq("id",102);
	    c.add(cr);
	    Employee e=(Employee)c.uniqueResult();
	    System.out.println("***Employee Details********");
	    System.out.println(e.getId()+ " " +e.getName()+ " ");
	    
	}

}
