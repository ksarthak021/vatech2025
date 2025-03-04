package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hibernate1.customer;
import dao.CustomerDAO;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public void addCustomer(customer customer) {
        customerDAO.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customer customer = customerDAO.findById(customerId);
        if (customer != null) {
            customerDAO.delete(customer);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public customer getCustomerById(int customerId) {
        return customerDAO.findById(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<customer> getAllCustomers() {
        return customerDAO.findAll();
    }
}

