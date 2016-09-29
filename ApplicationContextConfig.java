package com.tronicsville.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.DAO.ProductDao;
import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.DAO.DaoImpl.CategoryDaoImpl;
import com.tronicsville.DAO.DaoImpl.ProductDaoImpl;
import com.tronicsville.DAO.DaoImpl.SupplierDaoImpl;
import com.tronicsville.model.Category;
import com.tronicsville.model.Product;
import com.tronicsville.model.RegisterModel;
import com.tronicsville.model.Supplier;


@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationContextConfig {

	    
	    @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	    	dataSource.setUsername("sa");
	    	dataSource.setPassword("");
	    	
	    	return dataSource;
	    }
	    
	    
	    private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.setProperty("hibernate.hbm2ddl.auto","update");
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	    
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClasses(RegisterModel.class);
	    	sessionBuilder.addAnnotatedClasses(Category.class);
	    	sessionBuilder.addAnnotatedClasses(Supplier.class);
	    	sessionBuilder.addAnnotatedClasses(Product.class);
	        	return sessionBuilder.buildSessionFactory();
	    }
	    
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
		@Autowired
		@Bean(name = "categoryDao")
		public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
			return new CategoryDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "supplierDao")
		public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "productDao")
		public ProductDao getProductDao(SessionFactory sessionFactory) {
			return new ProductDaoImpl(sessionFactory);
		}

	    
	}




