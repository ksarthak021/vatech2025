package dao;


import java.util.List;
import hibernate1.LiveOrderItem;

public interface LiveOrderItemDAO {
    List<LiveOrderItem> getAllLiveOrderItems();
}