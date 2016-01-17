package com.nirvana.parkingtom.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("sessionUtil")
public class SessionUtil {

	private SessionUtil(){
		
	}

	public Session getSessionInstance() {
		ApplicationContext context = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sessionFactory;
		sessionFactory = (SessionFactory)context.getBean("hibernate4AnnotatedSessionFactory");
		return sessionFactory.openSession();

	}
}