package com.valtech.training.assignmentinventorymvc.entities.services;

import java.util.List;

import com.valtech.training.assignmentinventorymvc.enums.OrderStatus;
import com.valtech.training.assignmentinventorymvc.repos.ItemRepo;
import com.valtech.training.assignmentinventorymvc.repos.OrderRepo;
import com.valtech.training.assignmentinventorymvc.vos.OrderVO;

public interface OrderService {
	 
	void placeOrder(OrderVO orderVO); 
	void updateOrderStatus(int orderId, OrderStatus status);	 
	OrderVO getOrderById(int orderId);	 
	List<OrderVO> getAllOrders();	 
	void setItemRepo(ItemRepo itemRepo);	 
	void setOrderRepo(OrderRepo orderRepo);
 
}
