package hibernate1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public void addCustomer(customer customer) {
        customerDAO.save(customer);
    }

    public void removeCustomer(customer customer) {
        customerDAO.delete(customer);
    }

    public List<customer> getCustomers() {
        return customerDAO.getAll(customer.class);
    }
}

