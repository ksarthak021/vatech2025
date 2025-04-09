package com.valtech.training.assignmentinventorymvc.entities.services;

import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignmentinventorymvc.entities.LineItem;
import com.valtech.training.assignmentinventorymvc.repos.LineItemRepo;
import com.valtech.training.assignmentinventorymvc.repos.OrderRepo;
import com.valtech.training.assignmentinventorymvc.vos.LineItemVO;
 

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LineItemServiceImpl implements LineItemService {
	@Autowired
	    private LineItemRepo lineItemRepo;
	    
	    @Autowired
	    private OrderRepo orderRepo;
	 
	    
	    @Override
	public LineItemVO saveLineItem(LineItemVO livo) {
	LineItem lineItem = lineItemRepo.save(livo.to());
	        return LineItemVO.from(lineItem);
	    }
	 
	   
	    @Override
	public LineItemVO updateLineItem(int id, LineItemVO livo) {
	        LineItem lineItem = lineItemRepo.getReferenceById(id);
	        livo.updateTo(id, lineItem);
	        return LineItemVO.from(lineItem);
	    }
	 
	  
	    @Override
	public LineItemVO getLineItem(int id) {
	        LineItem lineItem = lineItemRepo.getReferenceById(id);
	        return LineItemVO.from(lineItem);
	    }
	 
	  
	    @Override
	public List<LineItemVO> getAllLineItems() {
	        return lineItemRepo.findAll().stream()
	                .map(lineItem -> LineItemVO.from(lineItem))
	                .collect(Collectors.toList());
	    }
	 

}