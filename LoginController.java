package com.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.RegisterDao;
import com.Dao.SupplierDao;
import com.Model.Category;
import com.Model.Product;
import com.Model.RegisterModel;
import com.Model.Supplier;

@Controller
public class LoginController {
	@Autowired
     RegisterModel registerModel;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	 RegisterDao registerDao;
	
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
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register(@ModelAttribute RegisterModel registerModel){
		ModelAndView mv;
		mv= new ModelAndView("register");
		return mv;
	}
	
	@RequestMapping(value="/registersuccess")
	public ModelAndView success(@ModelAttribute RegisterModel registerModel)
	{
		ModelAndView mv;	
		mv= new ModelAndView("login");
		int j=0;
		
		 List<RegisterModel> registermodellist=registerDao.List();

		    for (int i=0; i< registermodellist.size(); i++) {
		        if(registerModel.getEmailid().equals(registermodellist.get(i).getEmailid())) {
		        	mv= new ModelAndView("register");
		        	mv.addObject("msg","Email already exists"+  registerModel.getEmailid());
		            j=1;
		            
		        }	       

		        if(registerModel.getUsername().equals(registermodellist.get(i).getUsername())) {
		            mv= new ModelAndView("register");
		            mv.addObject("msg","Username already exists"+  registerModel.getUsername());
		            j=1;
		            }
		        if(registerModel.getMobilenumber().equals(registermodellist.get(i).getMobilenumber())) {
		            mv= new ModelAndView("register");
		            mv.addObject("msg","mobile number already exists"+registerModel.getMobilenumber());
		            j=1;
		            }
		    }
		    if(j==0){
		    	mv.addObject("msg","You have registered successfully, please log in to continue");
			    registerDao.save(registerModel);    	
		    }
		    return mv;
	}
	@RequestMapping(value="/loginsuccess")
	public String login(@RequestParam(value="username") String name,
			@RequestParam(value="password") String password,HttpSession session,Model model){
		System.out.println("login controller");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		
		String role="ROLE_USER";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		/*registerModel = registerDao.isValidUser(username, password);
		ModelAndView mv = null;
		if(registerModel == null){
        mv = new ModelAndView ("login");
		mv.addObject("msg", "Invalid credentials please try again");
	} else {*/
		if (authority.getAuthority().equals(role)){
		session.setAttribute("categoryList", categoryDao.list());
		session.setAttribute("supplierList", supplierDao.list());
		session.setAttribute("productList", productDao.list());
		session.setAttribute("username", registerModel.getUsername());
		session.setAttribute("category", category);
		session.setAttribute("supplier", supplier);
		session.setAttribute("product", new Product());
		session.setAttribute("username", username);
		page="productview";
		break;
	}
	else {
		page="admin";
		break;
	}
	}
		
     return page;
	}
	
	@RequestMapping("/isValidUser")
	public ModelAndView validuser(@RequestParam(value="username")String name,@RequestParam(value="password")String password, HttpSession session,Model model){
		
	
		String message;
		ModelAndView mv ;
		
		
		if (registerDao.isValidUser(name,password)) 
		{
			message = "Successfully Logged in";
			 mv = new ModelAndView("user");
		} else{
			message="Please enter a valid username and password";
			mv=new ModelAndView("Success");
		}

		mv.addObject("message", message);
		mv.addObject("username",name);
		return mv;
	
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session){
		ModelAndView mv = new ModelAndView("home");
		session.invalidate();
		session=request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDao.list());
		return mv;
	}
	@RequestMapping(value="/login")
	public String login(){
	return "login";
	}	

	
}
