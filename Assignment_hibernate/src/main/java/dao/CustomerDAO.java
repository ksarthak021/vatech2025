package dao;

import java.util.List;
import hibernate1.customer;

public interface CustomerDAO {
	
	    void save(customer customer);
	    void delete(customer customer);
	    customer findById(int customerId);
	    List<customer> findAll();

}
