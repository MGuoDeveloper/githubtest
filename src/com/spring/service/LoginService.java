package com.spring.service;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.form.LoginForm;

public class LoginService {
	
	static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public boolean isUserExists(LoginForm user){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String username = user.getUsername();
		String password = user.getPassword();
		Query query = session.createQuery("from LoginForm where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		transaction.commit();
		List<?> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
