package com.jwt.hibernate;
 


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
 
public class SimpleTest extends HttpServlet{
 
	
		
		private static final long serialVersionUID = 1L;

		public SimpleTest() {
			super();
		}

		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
		
		
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Student student = new Student();
        student.setName("Mukesh");
        student.setRoll("101");
        student.setPhone("8888");
        student.setDegree("B.E");
 
        Transaction tx = session.beginTransaction();
        session.save(student);
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
        String json = new Gson().toJson(student);
		response.setContentType("application/json");
		response.getWriter().write(json);
        
	} 
    
}	
	

