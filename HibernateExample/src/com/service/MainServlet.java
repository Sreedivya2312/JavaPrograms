package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Names n=new Names();
		//n.setFname("S");
		//n.setLname("Divya");
		//n.setMname("Sree");

		Bean bean = new Bean();
		//bean.setBid(6);
		//bean.setName(n);
		//bean.setPlace("Chennai");

		Configuration con = new Configuration().configure().addAnnotatedClass(Bean.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		bean=session.get(Bean.class, 6);
		//session.save(bean);
		PrintWriter out=response.getWriter();
		out.println(bean);
	
		tx.commit();
	    
	}
}
