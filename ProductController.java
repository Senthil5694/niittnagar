package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.Util.FileUtil;
import com.Model.Category;
import com.Model.Product;
import com.Model.Supplier;

@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	private String path = "F:\\tronicsville\\image";
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String listProducts(Model model)	{
		model.addAttribute("product",new  Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier",new Supplier());
		model.addAttribute("productlist",  this.productDao.list());
		model.addAttribute("categorylist", this.categoryDao.list());
		model.addAttribute("'supplierlist", this.supplierDao.list());
		return "product";
	}
	
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("image") MultipartFile file){
	Category category = categoryDao.getByName(product.getCategory().getCname());
	Supplier supplier = supplierDao.getByName(product.getSupplier().getName());
	product.setCategory(category);
	product.setSupplier(supplier);
	productDao.save(product);
	FileUtil.upload(path , file , product.getPid() + ".jpg");
	return "product";
	}
	@RequestMapping("/product/remove/{id}")
	public String deleteProduct(@PathVariable("id") String id,ModelMap model)throws Exception{
		try{
			productDao.delete(id);
			model.addAttribute("message", "Successfully Deleted");
		}catch (Exception e){
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "product";
		}
		@RequestMapping("product/edit/{id}")
		public String editproduct(@PathVariable("id") String id, Model model){
			System.out.println("editproduct");
			model.addAttribute("product", this.productDao.get(id));
			model.addAttribute("listproducts", this.productDao.list());
			model.addAttribute("categoryList", this.categoryDao.list());
			model.addAttribute("supplierList", this.supplierDao.list());
			return "product";		
	}
		@RequestMapping("/product/get/{id}")
		public String getSelectedProduct(@PathVariable("id") String id,Model model,RedirectAttributes redirectattributes){
			redirectattributes.addFlashAttribute("selectedProduct", productDao.get(id));
			return "product";
			
		}

}
