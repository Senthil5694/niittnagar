/*package com.tronicsville.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tronicsville.DAO.SupplierDao;
import com.tronicsville.model.Category;
import com.tronicsville.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	Model mv;
	
	@RequestMapping(value="/supplier", method=RequestMethod.GET)
	public String listsupplier(Model model){
	model.addAttribute("supplier",supplier);
	model.addAttribute("supplierDao",this.supplierDao.list());
	return "supplier";
	}
	@RequestMapping(value="/supplier/add", method=RequestMethod.POST)
	public String addsupplier(Model model){
		supplierDao.save(supplier);
		return "supplier";
	}
	@RequestMapping("/supplier/remove/{id}")
	public ModelAndView deletesupplier(@PathVariable("id") String id)throws Exception{
		boolean flag = supplierDao.delete(id);
		ModelAndView mv = new ModelAndView("supplier");
				String msg= "Successfull done the operation";
		if(flag!=true)
		{
			msg = "operation could not success";
		}
		mv.addObject("msg", msg);
		return mv;
	}
	@RequestMapping("/supplier/edit/{id}")
	public String editsupplier(@ModelAttribute("supplier")Supplier category){
		supplierDao.update(supplier);
		return "supplier";
	}
}
*/