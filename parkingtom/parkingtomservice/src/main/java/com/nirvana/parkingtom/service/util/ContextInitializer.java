package com.nirvana.parkingtom.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextInitializer implements ApplicationContextAware{

	public ContextInitializer(){
		super();
	}
	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
				this.applicationContext = applicationContext;
	}
	
	public static Object getBean(String beanName){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		return applicationContext.getBean(beanName);
	}

}
