package com.tronicsville.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.DAO.ProductDao;
import com.tronicsville.DAO.RegisterDao;
import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.model.Category;
import com.tronicsville.model.Product;
import com.tronicsville.model.RegisterModel;
import com.tronicsville.model.Supplier;

@Controller
public class LoginController {
	
	@Autowired
	RegisterModel registerModel;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private Product product;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/signin")
	public ModelAndView login(@RequestParam(value="name") String username,
			@RequestParam(value="password") String password){
		registerModel = registerDao.isValidUser(username, password);
		ModelAndView mv = null;
		if(registerModel == null){
        mv = new ModelAndView ("home");
		mv.addObject("ërror message", "Invalid credentials please try again");
	} else {
		if (registerModel.getRole().equals("ROLE_ADMIN")){
			mv = new ModelAndView("admin");
		session.setAttribute("categoryList", categoryDao.list());
		session.setAttribute("supplierList", supplierDao.list());
		session.setAttribute("productList", productDao.list());
		
		session.setAttribute("category", category);
		session.setAttribute("supplier", supplier);
		session.setAttribute("product", product);
	}
	else if (registerModel.getRole().equals("ROLE_USER")){
			mv = new ModelAndView("home");
		session.setAttribute("username", registerModel.getUsername());
	}
    }
	return mv;	
	}
}
	


