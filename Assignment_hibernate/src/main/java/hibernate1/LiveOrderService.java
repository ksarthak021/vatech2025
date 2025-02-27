package hibernate1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LiveOrderService {
    @Autowired
    private LiveOrderItemDAO liveOrderItemDAO;

    public List<LiveOrderItem> getLiveOrderItems() {
        return liveOrderItemDAO.getAll(LiveOrderItem.class);
    }
}

