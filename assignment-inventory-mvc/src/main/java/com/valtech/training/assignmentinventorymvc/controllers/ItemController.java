package com.valtech.training.assignmentinventorymvc.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.training.assignmentinventorymvc.entities.services.ItemService;
import com.valtech.training.assignmentinventorymvc.vos.ItemVO;


@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping("/item")
	public String item() {
		return "item";
	}
	
	@RequestMapping(path="item",method = RequestMethod.POST)
	public String allItemForm(@ModelAttribute ("ivo")ItemVO ivo,Model model) {
		System.out.println(ivo);
		itemService.saveItem(ivo);
		model.addAttribute("ivo", itemService.getAllItems());
		return "item";
	}
}