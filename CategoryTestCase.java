package com.tronicsville.JunitTestCase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {
	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Category category;
	
	
	@Before
	public void initialize (){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.tronicsville");
	context.refresh();
	category = (Category) context.getBean("category");
	categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
	@Test
	public void CreateCategoryTestCase()
	{
		category.setId("cat_2");
		category.setName("catee");
		category.setDescription("hgvg");
		Assert.assertEquals(true,categoryDao.save(category));		
	}
}

