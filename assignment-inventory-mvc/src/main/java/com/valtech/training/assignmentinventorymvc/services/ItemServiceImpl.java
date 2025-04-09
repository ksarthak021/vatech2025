package com.valtech.training.assignmentinventorymvc.entities.services;

import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignmentinventorymvc.entities.Item;
import com.valtech.training.assignmentinventorymvc.repos.ItemRepo;
import com.valtech.training.assignmentinventorymvc.vos.ItemVO;
 

 
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepo itemRepo;
	 
	    @Override
	public ItemVO saveItem(ItemVO ivo) {
	Item item = itemRepo.save(ivo.to());
	        return ItemVO.from(item);
	    }
	 
	    @Override
	public ItemVO updateItem(int id, ItemVO ivo) {
	        Item item = itemRepo.getReferenceById(id);
	        ivo.updateTo(id, item);
	        return ItemVO.from(item);
	    }
	 
	    @Override
	public ItemVO getItem(int id) {
	        Item item = itemRepo.getReferenceById(id);
	        return ItemVO.from(item);
	    }
	 
	    @Override
	public List<ItemVO> getAllItems() {
	        return itemRepo.findAll().stream()
	                       .map(item -> ItemVO.from(item))
	                       .collect(Collectors.toList());
	    }
	    @Override
	public void updateInventory(int itemId, int newQuantity) {
	        Item item = itemRepo.getReferenceById(itemId);
	        
	        if (item != null) {
	            item.setQuantity(newQuantity);
	            item.setReorder(Math.max(item.getMaxQuantity() - newQuantity, 0));
	            
	            itemRepo.save(item);
	        }
	    }
	 
	    @Override
	public void resetInventory(Item item) {
	        item.setQuantity(item.getMaxQuantity());
	        item.setReorder(0);
	        itemRepo.save(item);
	    }
	    public void setItemRepo(ItemRepo itemRepo) {
	this.itemRepo = itemRepo;
	}
}