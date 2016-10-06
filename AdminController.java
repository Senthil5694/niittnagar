package com.tronicsville.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.DAO.ProductDao;
import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.model.Category;
import com.tronicsville.model.Product;
import com.tronicsville.model.Supplier;

@Controller
public class AdminController {
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("managecategories")
	public ModelAndView categories(){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("categoryList", categoryDao.list());
		return mv;
	}
	@RequestMapping("manageproducts")
	public ModelAndView products(){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("product", product);
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("productList", productDao.list());
		return mv;		
	}
	@RequestMapping("managesupplier")
	public ModelAndView supplier(){
	ModelAndView mv = new ModelAndView("home");
	mv.addObject("supplier", supplier);
	mv.addObject("isAdminClickedSupplier", "true");
	mv.addObject("supplierList", supplierDao.list());
	return mv;
	}
}
