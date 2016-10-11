/*package com.tronicsville.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tronicsville.DAO.CategoryDao;
import com.tronicsville.model.Category;

@Controller
public class CategoryController {
	
	@Autowired(required=true)
	private CategoryDao categoryDao;
	
	@Autowired(required=true)
	private Category category;
	
	@Autowired(required=true)
	Model mv;
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String listcategory(Model model){
	model.addAttribute("category",category);
	model.addAttribute("categoryDao",this.categoryDao.list());
	return "category";
	}
	@RequestMapping(value="/category/add", method=RequestMethod.POST)
	public String addcategory(Model model){
		categoryDao.save(category);
		return "category";
	}
	@RequestMapping("/category/remove/{id}")
	public ModelAndView deletecategory(@PathVariable("id") String id)throws Exception{
		boolean flag = categoryDao.delete(id);
		ModelAndView mv = new ModelAndView("category");
				String msg= "Successfull done the operation";
		if(flag!=true)
		{
			msg = "operation could not success";
		}
		mv.addObject("msg", msg);
		return mv;
	}
	@RequestMapping("/category/edit/{id}")
	public String editcategory(@ModelAttribute("category")Category category){
		categoryDao.update(category);
		return "category";
	}
	
		
	}
	

*/