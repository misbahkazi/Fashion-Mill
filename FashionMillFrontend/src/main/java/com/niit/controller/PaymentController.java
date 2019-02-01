package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDetailDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;
import com.niit.model.UserDetail;

@Controller
public class PaymentController {
	
	@Autowired
	CartDAO cartDAO;
	
    @Autowired
    ProductDAO productDAO;
    
    @Autowired
    UserDetailDAO userDAO;
    
    
    @RequestMapping("/checkout")
    public String checkout(Model m,HttpSession session)
    {
  	  String username=(String)session.getAttribute("username");
  		List<CartItem> cartItemList=cartDAO.listCartItems(username);
  		
  		m.addAttribute("cartItemList", cartItemList);
  		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
  		
  		UserDetail userDetail=userDAO.getUser(username);
  		
  	    String address=userDetail.getCustomerAddr();
  	    
  	    m.addAttribute("addr", address);
  	  
  	    return"OrderConfirm";
    }
    
    
    public int getGrandTotal(List<CartItem> cartList)
  	 {
  		int grandTotal=0,count=0;
  		while(count<cartList.size())
  		{
  			grandTotal=grandTotal+(cartList.get(count).getQuantity()*cartList.get(count).getPrice());
  			count++;
  		}
  		return grandTotal;
  	}

    
    
    
    @RequestMapping(value="/UpdateAddr", method=RequestMethod.POST)
    public String UpdateAddr(@RequestParam("addr")String addr,Model m, HttpSession session)
    {
  	  String username=(String)session.getAttribute("username");
  		List<CartItem> cartItemList=cartDAO.listCartItems(username);
  		
  		m.addAttribute("cartItemList", cartItemList);
  		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
  		
  		UserDetail userdetail=userDAO.getUser(username);
  		userdetail.setCustomerAddr(addr);		
  		userDAO.updateAddress(userdetail);

  	    String address=userdetail.getCustomerAddr();
  	    
  	    m.addAttribute("addr", address);
  	  
  	  return "OrderConfirm";
    }
    
    @RequestMapping(value="/payment")
    public String paymentPage(Model m, HttpSession session)
    {
  	  
  	  
  	  return "Payment";
    }
    
    @RequestMapping(value="/receipt", method=RequestMethod.POST)
    public String generateReceipt(@RequestParam ("rd") String rd, Model m,HttpSession session)
    {
  	  String username=(String)session.getAttribute("username");
  	  
  	  OrderDetail orderDetail=new OrderDetail();
  	  orderDetail.setOrderDate(new Date());
  	  orderDetail.setShippingAddr(userDAO.getUser(username).getCustomerAddr());
  	  orderDetail.setPaymentMode(rd);
  	  orderDetail.setUsername(username);
  	  
  	  List<CartItem> cartItemList=cartDAO.listCartItems(username);
  		
  	  m.addAttribute("cartItemList", cartItemList);
  	  m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
  		
  	  orderDetail.setTotalAmount(this.getGrandTotal(cartItemList));
  	  
  	  orderDAO.saveOrder(orderDetail);
  	  orderDAO.updateCart(username);
  	  
  	  m.addAttribute("orderDetail", orderDetail);
  	  
  	  return "Receipt";
    }
    
    

}
