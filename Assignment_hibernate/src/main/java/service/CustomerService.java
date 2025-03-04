package service;

import hibernate1.customer;
import java.util.List;

public interface CustomerService {
    void addCustomer(customer customer);
    void deleteCustomer(int customerId);
    customer getCustomerById(int customerId);
    List<customer> getAllCustomers();
}