package com.tronicsville.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.model.Category;
import com.tronicsville.model.Supplier;

public class SupplierTest {
	public static void main(String[] args){
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.tronicsville");
	context.refresh();
	
	SupplierDao supplierDao =(SupplierDao) context.getBean("supplierDao");
	Supplier supplier = (Supplier) context.getBean("supplier");
	
    supplier.setId("sup_001");
    supplier.setName("RKO");
    supplier.setAddress("chennai");
    
    supplierDao.save(supplier);
    
    System.out.println("Data inserted into the database successfully");
}
}