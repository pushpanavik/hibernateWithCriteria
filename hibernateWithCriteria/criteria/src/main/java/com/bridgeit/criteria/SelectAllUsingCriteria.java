package com.bridgeit.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Employee;

public class SelectAllUsingCriteria {
	public static void main(String[] args) {
		
		 Configuration cfg=new Configuration().configure("resources/db.config.xml");
	     
	     SessionFactory sessionFactory=cfg.buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     @SuppressWarnings("deprecation")
		Criteria c=session.createCriteria(Employee.class);
	     
	     List<Employee> list=c.list();
	     
	     for(Employee emp: list)
	     {
	    	 System.out.println(emp.getMobileNumber() + " " +emp.getId()+ " " +emp.getName());
	     }
	      
	}   
}
