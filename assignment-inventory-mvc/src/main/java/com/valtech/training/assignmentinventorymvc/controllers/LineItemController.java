package com.valtech.training.assignmentinventorymvc.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valtech.training.assignmentinventorymvc.entities.services.LineItemService;
import com.valtech.training.assignmentinventorymvc.vos.LineItemVO;


@Controller
@RequestMapping("/lineItems")
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;

    @GetMapping
    public String getAllLineItems(Model model) {
        List<LineItemVO> lineItems = lineItemService.getAllLineItems();
        model.addAttribute("lineItems", lineItems);
        return "lineitem/list"; 
    }


    @PostMapping
    public String saveLineItem(@ModelAttribute LineItemVO lineItemVO, Model model) {
        LineItemVO savedLineItem = lineItemService.saveLineItem(lineItemVO);
        model.addAttribute("lineItem", savedLineItem);
        return "lineitem/success"; 
    }
   
    @PostMapping("/update/{id}")
    public String updateLineItem(@PathVariable int id, @ModelAttribute LineItemVO lineItemVO, Model model) {
        LineItemVO updatedLineItem = lineItemService.updateLineItem(id, lineItemVO);
        model.addAttribute("lineItem", updatedLineItem);
        return "lineitem/success"; 
    }

    @GetMapping("/{id}")
    public String getLineItem(@PathVariable int id, Model model) {
        LineItemVO lineItemVO = lineItemService.getLineItem(id);
        model.addAttribute("lineItem", lineItemVO);
        return "lineitem/detail"; 
    }
}