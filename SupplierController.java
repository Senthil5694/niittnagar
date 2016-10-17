package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.SupplierDao;
import com.Model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@RequestMapping(value="/supplierlist", method=RequestMethod.GET)
	public String listsupplier(Model model){
	model.addAttribute("supplier",supplier);
	model.addAttribute("supplierDao",this.supplierDao.list());
	return "supplier";
	}
	@RequestMapping(value="/addsupplier")
	public ModelAndView addsupplier(@ModelAttribute Supplier supplier){
		boolean flag=supplierDao.save(supplier);
		ModelAndView mv = new ModelAndView("suppliers");
		String msg= "Supplier added Successfully";
if(flag!=true)
{
	msg = "operation could not success";
}
mv.addObject("msg", msg);
return mv;
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
	public String editsupplier(@ModelAttribute("supplier")Supplier supplier){
		supplierDao.update(supplier);
		return "supplier";
	}
	@RequestMapping("/suppliers")
	public ModelAndView category(@ModelAttribute Supplier supplier){
		return new ModelAndView("suppliers");
	}
}
