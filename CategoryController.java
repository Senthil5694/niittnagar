package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Model.Category;

@Controller
public class CategoryController {
	@Autowired(required=true)
	private CategoryDao categoryDao;
	
	@Autowired(required=true)
	private Category category;
	
	@RequestMapping("/categories")
	public String listcategory(Model model){
	model.addAttribute("category",category);
	model.addAttribute("categoryList",this.categoryDao.list());
	return "categories";
	}
	@RequestMapping(value="/addcategories")
	public String addcategory(@ModelAttribute Category category,Model model){
		boolean flag=categoryDao.save(category);
	ModelAndView mv = new ModelAndView("categories");
	String msg="category added successfully";
		model.addAttribute(msg,"category added successfully");
      if(flag!=true)
     {
	msg = "operation could not success";
    }
   mv.addObject("msg", msg);
    return "redirect:/categories";

	}
	@RequestMapping("/removecategory/{cid}")
	public String deletecategory(@PathVariable("cid") String id,Model model)throws Exception{
		boolean flag = categoryDao.delete(id);
		ModelAndView mv = new ModelAndView("categories");
				String msg= "Category Deleted Successfully";
		if(flag!=true)
		{
			msg = "operation could not success";
		}
		mv.addObject("msg", msg);
		return "redirect:/categories";
	}
	@RequestMapping("/editcategory/{cid}")
	public String editcategory(@ModelAttribute("category")Category category,Model model){
		categoryDao.update(category);
		model.addAttribute("category",category);
		model.addAttribute("categoryList",this.categoryDao.list());
		return "categories";
	}

	

}
