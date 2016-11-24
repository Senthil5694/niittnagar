package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CartItemDao;
import com.Dao.RegisterDao;
import com.Model.CartItem;
import com.Model.RegisterModel;

@Controller
@RequestMapping("/user/cart")
public class UserCartController {
	
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private CartItemDao cartitemdao;
	
	@Autowired
	private CartItem cartItem;
	
	
	@RequestMapping
	public String getcart(Principal username,Model model)
	{
		RegisterModel registerModel =registerDao.getcustomerbyusername(username.getName());
		int cartid=registerModel.getCart().getCartid();
		return "redirect:/user/cart/"+cartid;
	}
	@RequestMapping("/{cartid}")
	public String cart(@PathVariable(value="cartid")int cartid,Model model)
	{
		model.addAttribute("cartid", cartid);
		return "cart";
	}

	
	/*@RequestMapping("/{cartid}")
	public String getcart(@PathVariable(value="cartid") int cartid,Model model)
	{
		cartitemdao.getcartbycartid(cartid);
		model.addAttribute("cartitem", new CartItem());
		model.addAttribute("cartitemlist", this.cartitemdao.list());
		return "cart";
	}*/
}
