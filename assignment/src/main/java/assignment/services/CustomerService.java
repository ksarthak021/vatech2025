package assignment.services;

import java.util.List;

import assignment.classes.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);
	Customer getCustomer(int id);
	List<Customer> getAll();
	void updateCustomer(Customer customer);
	void deleteCustomer(int id);

}