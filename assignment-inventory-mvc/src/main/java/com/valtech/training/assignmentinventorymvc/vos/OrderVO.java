package com.valtech.training.assignmentinventorymvc.vos;

import java.util.List;

import com.valtech.training.assignmentinventorymvc.entities.Customer;
import com.valtech.training.assignmentinventorymvc.entities.LineItem;
import com.valtech.training.assignmentinventorymvc.entities.Order;
import com.valtech.training.assignmentinventorymvc.enums.OrderStatus;

public record OrderVO(int orderId, OrderStatus status, Customer customer, List<LineItem> lineItems) {
	public static OrderVO from(Order o) {
		return new OrderVO(o.getOrderId(),o.getStatus(),o.getCustomer(),o.getLineItems());
	}
	public Order to() {
		return new Order(orderId,status,customer,lineItems);
	}
}