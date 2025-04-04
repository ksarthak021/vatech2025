package com.valtech.training.assignmentinventorymvc.vos;

import com.valtech.training.assignmentinventorymvc.entities.Item;

public record ItemVO(int id,String name, String description, int quantity, int reorder, int maxQuantity) {
	public static ItemVO from(Item i) {
		return new ItemVO(i.getId(),i.getName(),i.getDescription(),i.getQuantity(),i.getReorder(),i.getMaxQuantity());
	}
	public Item to() {
		return new Item(id,name,description,quantity,reorder,maxQuantity);
	}
	public void updateTo(int id,Item i) {
		i.setDescription(description);
		i.setName(name);
		i.setQuantity(quantity);
		i.setReorder(reorder);
		i.setMaxQuantity(maxQuantity);
	}
}
