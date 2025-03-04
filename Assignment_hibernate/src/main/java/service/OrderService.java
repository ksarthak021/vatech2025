package service;

import hibernate1.order;
import java.util.List;

public interface OrderService {
    List<order> getAllOrders();
}