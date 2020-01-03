package com.service;

import java.beans.Beans;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String args[]) {
		
		//Names n=new Names();
		//n.setFname("S");
		//n.setLname("Divya");
		//n.setMname("Sree");

	    //Bean bean=new Bean();
		//bean.setBid(15);
		//bean.setName("Aishu");
		//bean.setPlace("Trichy");
		String pl="Divya";

		Configuration con = new Configuration().configure().addAnnotatedClass(Bean.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query q=session.createQuery(" from Bean");
		List<Bean> b=q.list();
		for(Bean bb:b) {
			System.out.println(bb);
		}
		//q.setParameter("pl", pl);
		//Object name=(Object)q.uniqueResult();
        //Object[] bean=(Object[])q.uniqueResult();
      //for(Object o:bean) {
		//System.out.println(name);
	//}
		//session.save(bean);
	
		//tx.commit();
	    
	}
}
