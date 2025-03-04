package service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hibernate1.order;
import dao.OrderDAO;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    @Override
    public List<order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}

