package com.valtech.training.assignmentinventorymvc.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Item {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itemseq")
	@SequenceGenerator(name = "itemseq",sequenceName = "item_seq",allocationSize = 1)
	private int id;
	private String name;
	private String description;
	private int quantity;
	private int reorder;
	private int maxQuantity;
	@OneToMany(mappedBy = "item",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<LineItem> lineItems;
	public Item() {}
	public Item(int id,String name, String description, int quantity, int reorder, int maxQuantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reorder = reorder;
		this.maxQuantity = maxQuantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getReorder() {
		return reorder;
	}
	public void setReorder(int reorder) {
		this.reorder = reorder;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
		+ ", reorder=" + reorder + ", maxQuantity=" + maxQuantity + "]";
		}
	}
