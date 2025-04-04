package com.valtech.training.assignmentinventorymvc.entities.services;

import java.util.List;

import com.valtech.training.assignmentinventorymvc.vos.LineItemVO;

public interface LineItemService {
	 
	LineItemVO saveLineItem(LineItemVO livo); 
	LineItemVO updateLineItem(int id, LineItemVO livo);	 
	LineItemVO getLineItem(int id);	 
	List<LineItemVO> getAllLineItems();
	 
}
