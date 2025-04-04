package com.valtech.training.assignmentinventorymvc.controllers;


 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.assignmentinventorymvc.entities.services.CustomerService;
import com.valtech.training.assignmentinventorymvc.vos.CustomerVO;

 
 
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public String customer() {
		return "customer";
	}
	
	@RequestMapping(path="customer",method=RequestMethod.POST)
	public String allCustomerForm(@ModelAttribute ("cvo")CustomerVO cvo,Model model) {
		System.out.println(cvo);
		customerService.saveCustomer(cvo);
		model.addAttribute("cvo", customerService.getAllCustomer());
		return "customer";
	}
}