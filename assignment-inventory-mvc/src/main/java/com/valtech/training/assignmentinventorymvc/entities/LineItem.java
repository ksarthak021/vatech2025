package com.valtech.training.assignmentinventorymvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
 
@Entity
public class LineItem {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "LineItemseq")
	@SequenceGenerator(name = "LineItemseq",sequenceName = "LineItem_seq",allocationSize = 1)
	private int id;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	 
	public LineItem() {}
	 
	public LineItem(int id,int quantity, Order order, Item item) {
		this.id = id;
		this.quantity = quantity;
		this.order = order;
		this.item = item;
	}
	 
	public int getId() {
		return id;
	}
	 
	public void setId(int id) {
		this.id = id;
	}
	 
	public int getQuantity() {
		return quantity;
	}
	 
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 
	public Order getOrder() {
		return order;
	}
	 
	public void setOrder(Order order) {
		this.order = order;
	}
	 
	public Item getItem() {
		return item;
	}
	 
	public void setItem(Item item) {
		this.item = item;
	}
	 
	@Override
	public String toString() {
		return "LineItem [id=" + id + ", quantity=" + quantity + ", order=" + order.getOrderId() + ", item=" + item + "]";
	}
	}
