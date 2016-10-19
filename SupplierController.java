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
	
	@RequestMapping(value="/suppliers", method=RequestMethod.GET)
	public String listsupplier(Model model){
	model.addAttribute("supplier",supplier);
	model.addAttribute("supplierList",this.supplierDao.list());
	return "suppliers";
	}
	@RequestMapping(value="/addsupplier")
	public String addsupplier(@ModelAttribute Supplier supplier,Model model){
		boolean flag=supplierDao.save(supplier);
	ModelAndView mv = new ModelAndView();
		String msg= "Supplier added Successfully";
if(flag!=true)
{
	msg = "operation could not success";
}
mv.addObject("msg", msg);
return "redirect:/suppliers";
	}
	@RequestMapping("/removesupplier/{id}")
	public String deletesupplier(@PathVariable("id") String id, Model model)throws Exception{
		boolean flag = supplierDao.delete(id);
		ModelAndView mv = new ModelAndView();
				String msg= "Successfully deleted";
		if(flag!=true)
		{
			msg = "operation could not success";
		}
		mv.addObject("msg", msg);
		return "redirect:/suppliers";
	}
	@RequestMapping("editsupplier/{id}")
	public String editsupplier(@ModelAttribute("supplier")Supplier supplier,Model model){
		supplierDao.update(supplier);
		model.addAttribute("supplier",supplier);
		model.addAttribute("supplierList",this.supplierDao.list());
		return "suppliers";
	}

}
