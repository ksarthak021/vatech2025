package assignment.services;

import java.util.List;

import assignment.classes.OrderEn;

public interface OrderService {

	void statusOfOrder(int id, String status);
	void addOrder(OrderEn order);
	OrderEn getOrder(int id);
	List<OrderEn> getAll();
	void updateOrder(OrderEn order);
	void deleteOrder(int id);
}