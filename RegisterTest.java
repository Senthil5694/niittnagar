package com.tronicsville.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tronicsville.DAO.RegisterDao;
import com.tronicsville.model.RegisterModel;

public class RegisterTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.tronicsville");
		context.refresh();
		
		RegisterDao registerDao = (RegisterDao) context.getBean("registerDao");
		RegisterModel register =(RegisterModel) context.getBean("register");
		
		
		/*register.setUsername("senthil");
		register.setPassword("12345");
		register.setEmailid("hello");
		register.setFirstname("welcome");
		register.setLastname("bjh");
		register.setMobilenumber("vhghvg");
		register.setAddress("hvghv");
		register.setId("user_001");*/
		
		registerDao.delete("user_001");
		
		
		System.out.println("Data inserted into the database successfully");
		
		

	}

}
