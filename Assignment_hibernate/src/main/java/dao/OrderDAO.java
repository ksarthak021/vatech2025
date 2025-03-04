package dao;

import java.util.List;
import hibernate1.order;

public interface OrderDAO {
    List<order> getAllOrders();
}