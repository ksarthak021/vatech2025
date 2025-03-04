package service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hibernate1.LiveOrderItem;
import dao.LiveOrderItemDAO;
import java.util.List;

@Service
public class LiveOrderItemServiceImpl implements LiveOrderItemService {

    @Autowired
    private LiveOrderItemDAO liveOrderItemDAO;

    @Transactional
    @Override
    public List<LiveOrderItem> getAllLiveOrderItems() {
        return liveOrderItemDAO.getAllLiveOrderItems();
    }
}
