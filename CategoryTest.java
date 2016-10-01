package com.tronicsville.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.model.Category;

public class CategoryTest {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.tronicsville");
		
		context.refresh();
		
		CategoryDao categoryDao =(CategoryDao) context.getBean("categoryDao");
		
		Category category = (Category) context.getBean("category");
	
       // category.setId("cat_002");
       // category.setName("mobiles");
       // category.setDescription("Electronics");
	
		
		categoryDao.delete("cat_002");
		
		System.out.println("Data inserted into the database successfully");
	}

}
