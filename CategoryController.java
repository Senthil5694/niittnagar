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
	
	
	@RequestMapping(value="/categorieslist", method=RequestMethod.GET)
	public String listcategory(Model model){
	model.addAttribute("category",category);
	model.addAttribute("categoryList",this.categoryDao.list());
	return "category";
	}
	@RequestMapping(value="/addcategories")
	public ModelAndView addcategory(@ModelAttribute Category category){
		boolean flag=categoryDao.save(category);
		ModelAndView mv = new ModelAndView("categories");
		String msg= "Category added Successfully";
if(flag!=true)
{
	msg = "operation could not success";
}
mv.addObject("msg", msg);
return mv;

	}
	@RequestMapping("/category/remove/{id}")
	public ModelAndView deletecategory(@PathVariable("id") String id)throws Exception{
		boolean flag = categoryDao.delete(id);
		ModelAndView mv = new ModelAndView("category");
				String msg= "Category Deleted Successfully";
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
	@RequestMapping("/categories")
	public ModelAndView category(@ModelAttribute Category category){
		return new ModelAndView("categories");
	}
	

}
