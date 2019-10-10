package com.example.petmeal.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.petmeal.domain.Order;
import com.example.petmeal.domain.Products;
import com.example.petmeal.domain.User;
import com.example.petmeal.service.OrderService;
import com.example.petmeal.service.ProductsService;
import com.example.petmeal.service.UserService;

import lombok.AllArgsConstructor;

@Controller //컨트롤러 빈으로 등록
@AllArgsConstructor
public class ProductController {
	
	private ProductsService productsService;
	private UserService userService;
	private OrderService orderService;
	
	@RequestMapping("/products/{products_id}") //시작 페이지
	public ModelAndView products(ModelAndView mav,@PathVariable Long products_id) {
		mav.setViewName("products"); //뷰의 이름
		productsService.findByProductsId(products_id).ifPresent(o -> mav.addObject("products", o));
		List<Products> lists=productsService.findAll();
		mav.addObject("lists",lists);
		return mav; //화면 출력
		
		 //데이터 저장
	}
	@RequestMapping("/createorder") //시작 페이지
	public ModelAndView createorder(ModelAndView mav, Order order, HttpServletRequest request,Principal principal) { //뷰의 이름
		String phone1=request.getParameter("phone1");
		String phone2=request.getParameter("phone2");
		String phone3=request.getParameter("phone3");
		order.setR_phonenumber(phone1+"-"+phone2+"-"+phone3);
		User currentUser=userService.findUserByEmail(principal.getName());
		order.setBuyerId((long) currentUser.getId());
		order.setProducts_id(Long.parseLong(request.getParameter("products_id")));
		order.setQuantity(Long.parseLong(request.getParameter("quantity")));
		orderService.save(order);
		Long o_id=order.getId();
		return new ModelAndView( "redirect:/orderinfo/"+o_id); //화면 출력
		
		 //데이터 저장
	}
	
	@RequestMapping("/order/{products_id}") //시작 페이지
	public ModelAndView order(ModelAndView mav,@PathVariable Long products_id,HttpServletRequest request, Principal principal) {
		mav.setViewName("order"); //뷰의 이름
		User currentUser=userService.findUserByEmail(principal.getName());
		Order order=new Order();
		if(request.getParameter("amount")==null) {
			return new ModelAndView( "redirect:/products/"+products_id);
		}
		Long amount=Long.parseLong(request.getParameter("amount"));
		Float sum=Float.parseFloat(request.getParameter("sum"));
		mav.addObject("order",order);
		mav.addObject("currentUser",currentUser);
		mav.addObject("amount",amount);
		mav.addObject("sum",sum);
		mav.addObject("products_id",products_id);
		return mav; //화면 출력
		
		 //데이터 저장
	}
	
	@RequestMapping("/orderinfo/{order_id}") //시작 페이지
	public ModelAndView orderinfo(ModelAndView mav,@PathVariable Long order_id,HttpServletRequest request) {
		mav.setViewName("orderinfo"); //뷰의 이름
		Optional<Order> optionalOrder=orderService.findOrderById(order_id);
		Order order=optionalOrder.get();
		mav.addObject("order",order);
		
		Long productsId=order.getProducts_id();
		Long buyerId=order.getBuyerId();

		productsService.findByProductsId(productsId).ifPresent(o -> mav.addObject("products", o));
		userService.findUserById(buyerId).ifPresent(o -> mav.addObject("user", o));
		
		
		
		return mav; //화면 출력
		
		 //데이터 저장
	}
	
	
	
	
}
