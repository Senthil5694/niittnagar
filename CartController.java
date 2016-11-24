package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Dao.CartDao;
import com.Dao.CartItemDao;
import com.Dao.ProductDao;
import com.Dao.RegisterDao;
import com.Model.Cart;
import com.Model.CartItem;
import com.Model.Product;
import com.Model.RegisterModel;


@Controller
@RequestMapping("/usercart/cart")
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CartItemDao cartitemdao;
	
	@Autowired
	private CartItem cartitem;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/refreshCart/{cartid}")
	public @ResponseBody
	Cart getcartbyid(@PathVariable(value="cartid") int cartid){
		return cartDao.getCartById(cartid);
	}
	 @RequestMapping(value = "/additem/{pid}", method = RequestMethod.PUT)
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void addItem (@PathVariable(value ="pid") String pid, Principal username) {

	    	RegisterModel registerModel = registerDao.getcustomerbyusername(username.getName());
	        Cart cart = registerModel.getCart();
	        Product product = productDao.get(pid);
	        List<CartItem> cartItems = cart.getCartItems();

	        for (int i=0; i<cartItems.size(); i++) {
	            if(product.getPid()==cartItems.get(i).getProduct().getPid()){
	                CartItem cartItem = cartItems.get(i);
	                cartItem.setPname(product.getName());
	                cartItem.setPrice(product.getPrice());
	                cartItem.setQuantity(cartItem.getQuantity()+1);
	                cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
	                cartitemdao.saveOrUpdate(cartItem);
	                session.setAttribute("cartid",registerModel.getCart());
	                session.setAttribute("pid", productDao.get(pid));

	                return;
	            }
	        }

	        CartItem cartItem = new CartItem();
	        cartItem.setProduct(product);
	        cartItem.setPname(product.getName());
	        cartItem.setPrice(product.getPrice());
	        cartItem.setQuantity(1);
	        cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
	        cartItem.setCart(cart);
	        cartitemdao.saveOrUpdate(cartItem);
	       
	    }
	
	@RequestMapping("/removeitem/{cartitemid}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeitem(@PathVariable(value="cartitemid") int cartitemid)
	{
	 cartitem=cartitemdao.getcartitem(cartitemid);
				cartitemdao.delete(cartitemid);
	}
	@RequestMapping("/clearcartitems/{cartid}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void clearcartitems (@PathVariable(value="cartid") int cartid)
	{
		 cart=cartDao.getCartById(cartid);
		cartDao.delete(cartid);
	}
	
	

}
/*@RequestMapping(value="/additem/{pid}",method=RequestMethod.PUT)
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void additem(@PathVariable(value="pid") String pid,Principal username)
{
	RegisterModel registerModel=registerDao.getcustomerbyusername(username.getName());
			Cart cart=registerModel.getCart();
	Product product=productDao.get(pid);
	List<CartItem> cartItems=cart.getCartItems();
	for (int i=0; i<cartItems.size(); i++) {
        if(product.getPid()==cartItems.get(i).getProduct().getPid()){
        	CartItem cartitem= cartItems.get(i);
        	cartitem.setPname(product.getName());
        	cartitem.setPrice(product.getPrice());
        	cartitem.setQuantity(cartitem.getQuantity()+1);
        	cartitem.setTotalPrice(product.getPrice()*cartitem.getQuantity());
        	cartitemdao.saveOrUpdate(cartitem);
        	return;
        	
        }
            
        }
	CartItem cartitem= new CartItem();
	cartitem.setProduct(product);
	cartitem.setPname(product.getName());
	cartitem.setPrice(product.getPrice());
	cartitem.setQuantity(1);
	cartitem.setTotalPrice(product.getPrice()*cartitem.getQuantity());
	cartitemdao.saveOrUpdate(cartitem);
}*/