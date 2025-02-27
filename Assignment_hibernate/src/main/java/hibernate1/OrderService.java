package hibernate1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    public void placeOrder(order order) {
        orderDAO.save(order);
    }

    public void updateOrderStatus(order order, String status) {
        order.setStatus(status);
        orderDAO.save(order);
    }
}

