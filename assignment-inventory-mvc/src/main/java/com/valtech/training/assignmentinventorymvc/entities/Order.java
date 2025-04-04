package com.valtech.training.assignmentinventorymvc.entities;

import java.util.ArrayList;
import java.util.List;

import com.valtech.training.assignmentinventorymvc.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "order_table")
public class Order {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	
	private int orderId;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<LineItem> lineItems;
	 
	public Order() {}
	 
	public Order(int orderId, OrderStatus status, Customer customer, List<LineItem> lineItems) {
		this.orderId = orderId;
		this.status = status;
		this.customer = customer;
		this.lineItems = lineItems;
	}
	 
	public int getOrderId() {
		return orderId;
	}
	 
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	 
	public OrderStatus getStatus() {
		return status;
	}
	 
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	 
	public Customer getCustomer() {
		return customer;
	}
	 
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	 
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	 
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public void addLineItem(LineItem lineItem) {
	if(lineItems == null) lineItems = new ArrayList<LineItem>();
	        lineItems.add(lineItem);
	        lineItem.setOrder(this);
	    }
	    
	    public void removeLineItem(LineItem lineItem) {
	        lineItems.remove(lineItem);
	        lineItem.setOrder(null);
	    }
	 
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", customer=" + customer + "]";
		}
	    
	 
	}