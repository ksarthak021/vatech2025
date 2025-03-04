package assignment.dao;

import java.util.List;

import assignment.classes.OrderEn;

public interface OrderDAO {

	void addOrder(OrderEn order);
	OrderEn getOrder(int id);
	List<OrderEn> getAll();
	void updateOrder(OrderEn order);
	void deleteOrder(int id);
}