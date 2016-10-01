package com.tronicsville.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tronicsville.DAO.ProductDao;
import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.model.Product;
import com.tronicsville.model.Supplier;

public class ProductTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.tronicsville");
		context.refresh();
		
		ProductDao productDao =(ProductDao) context.getBean("productDao");
		Product product = (Product) context.getBean("product");
		
	    product.setId("pro_001");
	    product.setName("laptop");
	    product.setPrice("50000");
	    
	    
	    productDao.save(product);
	    
	    System.out.println("Data inserted into the database successfully");

	}

}
