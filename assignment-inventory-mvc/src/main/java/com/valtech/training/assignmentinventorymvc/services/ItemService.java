package com.valtech.training.assignmentinventorymvc.entities.services;

import java.util.List;

import com.valtech.training.assignmentinventorymvc.entities.Item;
import com.valtech.training.assignmentinventorymvc.vos.ItemVO;

public interface ItemService {
	 
	ItemVO saveItem(ItemVO ivo);	 
	ItemVO updateItem(int id, ItemVO ivo);	 
	ItemVO getItem(int id); 
	List<ItemVO> getAllItems(); 
	void updateInventory(int itemId, int newQuantity); 
	void resetInventory(Item item);
 
}
