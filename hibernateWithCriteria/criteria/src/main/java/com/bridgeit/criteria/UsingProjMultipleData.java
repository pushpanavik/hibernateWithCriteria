package com.bridgeit.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import bean.Employee;

public class UsingProjMultipleData {
	public static void main(String[] args) {
		 Configuration cfg=new Configuration().configure("resources/db.config.xml");
		   
	     SessionFactory sessionFactory=cfg.buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     @SuppressWarnings("deprecation")
	     Criteria c=session.createCriteria(Employee.class);
	     Projection p=Projections.property("id");
	     Projection p1=Projections.property("name");
	     Projection p2=Projections.property("address");
	     
	     ProjectionList plist=Projections.projectionList();
	     plist.add(p);
	     plist.add(p1);
	     plist.add(p2);
	     
	     c.setProjection(plist);
	     
	     List<Object> obj=c.list();
	     for(Object e: obj)
	     {
	    	 Object[] arg=(Object[])e;
	    	 System.out.println(arg[0] +" " +  arg[1] +"  "+ arg[2]);
	     }
	    
	    
	     
	}
}
