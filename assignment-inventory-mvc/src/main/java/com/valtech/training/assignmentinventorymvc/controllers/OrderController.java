package com.valtech.training.assignmentinventorymvc.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.training.assignmentinventorymvc.entities.services.OrderService;
import com.valtech.training.assignmentinventorymvc.vos.OrderVO;



@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping("/order")
	public String order() {
		return "order";
	}
	
	@RequestMapping(path="order",method = RequestMethod.POST)
	public String  allOrderForm(@ModelAttribute ("ovo")OrderVO ovo,Model model) {
		System.out.println(ovo);
		orderService.placeOrder(ovo);
		model.addAttribute("ovo", orderService.getAllOrders());
		return "order";
	}
}